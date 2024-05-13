package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.TravelDocumentDao;
import it.epicode.trasporti.entities.stores.Reseller;
import it.epicode.trasporti.entities.stores.Store;
import it.epicode.trasporti.entities.stores.TicketMachine;
import it.epicode.trasporti.entities.tranports.Vehicle;
import it.epicode.trasporti.entities.travel_documents.Ticket;
import it.epicode.trasporti.entities.travel_documents.TravelDocument;
import it.epicode.trasporti.exceptions.StoreOutOfServiceException;
import it.epicode.trasporti.exceptions.VehicleNotFoundException;
import jakarta.persistence.NoResultException;

import java.time.LocalDate;
import java.util.Date;

public class TravelDocumentDaoImpl extends BaseDao implements TravelDocumentDao {

    @Override
    public void save(TravelDocument travelDocument){
        try{
            log.debug("Saving {}", travelDocument);
            var t = em.getTransaction();
            t.begin();
            em.persist(travelDocument);
            log.debug("Before commit {}", travelDocument);
            t.commit();
            log.debug("After commit {}", travelDocument);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

    //Metodo per generare un titolo di viaggio(biglietto, abbonamento settimanale o mensile)
    //Verifica lo stato del punto vendita da cui si vuole generarlo, e se questo è in funzione
    //chiama il metodo save per salvarlo nel db
    @Override
    public void emitDocument(TravelDocument travelDocument) {
        try {
            Store store = em.find(Store.class, travelDocument.getIssuingPlace());
            if (store instanceof TicketMachine) {
                TicketMachine machine = (TicketMachine) store;
                if (machine.isStatus()) {
                    save(travelDocument);
                } else {
                    throw new StoreOutOfServiceException("Distributore fuori servizio. Impossibile emettere titolo di viaggio");
                }
            } else if (store instanceof Reseller) {
                save(travelDocument);
            } else {
                throw new Exception("Tipo di punto di acquisto non riconosciuto");
            }
        } catch (Exception e) {
            log.error("Errore nell'emissione del documento: {}", e.getMessage());
        }
    }

    //Metodo per gestire òl'obliterazione del biglietto.
    //vengono salvati orario e mezzo su cui il biglietto è stato obliterato,
    //e lo stato del biglietto viene passato da valido a non valido (tramite il booleano "valid")
    @Override
    public void validateTicket(Long id, Vehicle place) throws Exception {
        Ticket ticket = em.find(Ticket.class, id);
            var t = em.getTransaction();
            try {
                t.begin();
                if (ticket != null && ticket.isValid()) {
                    ticket.setValid(false);
                    ticket.setValidationTime(new Date());
                    ticket.setValidationPlace(place);
                    em.merge(ticket);
                } else{
                    throw new Exception("Biglietto inesistente o non valido");
                }
                t.commit();
            } catch (Exception e) {
                if (t.isActive()) {
                    t.rollback();
                }
                throw e;
            }
    }

    //Metodo che restituisce il numero di biglietti vidimati su un determinato veicolo
    @Override
    public Long ticketsPerVehicle(Long vehicleId) {
        Vehicle vehicle;
        try {
            vehicle = em.find(Vehicle.class, vehicleId);
            if (vehicle == null) {
                throw new VehicleNotFoundException("Vehicle with ID " + vehicleId + " not found.");
            }
            return em.createQuery("SELECT COUNT(t) FROM Ticket t WHERE t.validationPlace = :vehicle", Long.class)
                    .setParameter("vehicle", vehicle)
                    .getSingleResult();
        } catch (VehicleNotFoundException e) {
            log.error("Vehicle not found error: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("An error occurred while trying to count tickets per vehicle: {}", e.getMessage());
            throw e;
        }
    }


    //Metodo che restituisce il numero di biglietti vidimati in un determinato intervallo temporale
    @Override
    public Long ticketsPerTimeRange(Date start, Date end){

        try {
            log.debug("Querying tickets from {} to {}", start, end);
            return em.createQuery("SELECT COUNT(t) FROM Ticket t WHERE t.validationTime >= :start AND t.validationTime <= :end", Long.class)
                    .setParameter("start", start)
                    .setParameter("end", end)
                    .getSingleResult();
        } catch (Exception e) {
            log.error("An error occurred while trying to count tickets time range: {}", e.getMessage());
            throw e;
        }
    }

    //Metodo che restiusce il numero di titoli di viaggio emessi da un determinato punto vendita
    @Override
    public Long documentsPerStore(Long storeId){

        try{
            return em.createQuery("SELECT COUNT(d) FROM TravelDocument d WHERE d.issuingPlace =:storeId", Long.class)
                    .setParameter("storeId", storeId)
                    .getSingleResult();
        }  catch (Exception e) {
        log.error("An error occurred while trying to count tickets per store: {}", e.getMessage());
        throw e;
        }

    }


    //Metodo che restituisce il numero di titoli di viaggio emessi in un determinato intervallo temporale
    @Override
    public Long documentsPerTimeRange(LocalDate start, LocalDate end){
        try {
        return em.createQuery("SELECT COUNT(d) FROM TravelDocument d WHERE d.issuingDate >= :start AND d.issuingDate <= :end", Long.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getSingleResult();
        } catch (Exception e) {
            log.error("An error occurred while trying to count travel documents time range: {}", e.getMessage());
            throw e;
        }
    }

    //Metodo che restituisce un booleano che permette di verificare la validità di un abbonamneto
    //basandosi sulla data di scadenza dello stesso.
    //Viene presa l'ultima data di rinnovo del suddetto abbonamento e vi vengono
    //aggiunti un numero di giorni pari alla durata dello stesso.
    //infine questa data viene confrontata con quella attuale per verificarne la validità
    @Override
    public boolean checkPassValidity(Long cardId) {
        try {
            LocalDate expDate = em.createQuery(
                            "SELECT t.expirationDate FROM TravelPass t WHERE t.user.id = " +
                                    "(SELECT c.user.id FROM Card c WHERE c.id = :cardId)", LocalDate.class)
                    .setParameter("cardId", cardId)
                    .getSingleResult();

            return expDate.isAfter(LocalDate.now());
        } catch (NoResultException e) {
            return false;
        }
    }
}
