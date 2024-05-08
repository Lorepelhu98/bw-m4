package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.TravelDocumentDao;
import it.epicode.trasporti.entities.tranports.Vehicle;
import it.epicode.trasporti.entities.travel_documents.Ticket;
import it.epicode.trasporti.entities.travel_documents.TravelDocument;

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

    @Override
    public Long ticketsPerVehicle(Long vehicleId) {
        Vehicle vehicle = null;
        try {
            vehicle = em.find(Vehicle.class, vehicleId);
            if (vehicle == null) {
                return 0L;
            }
            return em.createQuery("SELECT COUNT(t) FROM Ticket t WHERE t.validationPlace = :vehicle", Long.class)
                    .setParameter("vehicle", vehicle)
                    .getSingleResult();
        } catch (Exception e) {
            log.error("An error occurred while trying to count tickets per vehicle: {}", e.getMessage());
            return 0L;
        }
    }

    public Long ticketsPerTimeRange(Date start, Date end){

        try {
            log.debug("Querying tickets from {} to {}", start, end);
            return em.createQuery("SELECT COUNT(t) FROM Ticket t WHERE t.validationTime >= :start AND t.validationTime <= :end", Long.class)
                    .setParameter("start", start)
                    .setParameter("end", end)
                    .getSingleResult();
        } catch (Exception e) {
            log.error("An error occurred while trying to count tickets time range: {}", e.getMessage());
            return 0L;
        }
    }

}
