package it.epicode.trasporti.dao.interfaces;

import it.epicode.trasporti.entities.tranports.Vehicle;
import it.epicode.trasporti.entities.travel_documents.TravelDocument;

import java.time.LocalDate;
import java.util.Date;

public interface TravelDocumentDao {
    void save(TravelDocument travelDocument);

    void validateTicket(Long id, Vehicle place) throws Exception;

    Long ticketsPerVehicle(Long vehicleId);

    Long ticketsPerTimeRange(Date start, Date end);

    Long documentsPerStore(Long storeId);

    Long documentsPerTimeRange(LocalDate start, LocalDate end);

    boolean checkPassValidity(Long cardId);
}
