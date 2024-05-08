package it.epicode.trasporti.dao.interfaces;

import it.epicode.trasporti.entities.tranports.Vehicle;
import it.epicode.trasporti.entities.travel_documents.TravelDocument;

public interface TravelDocumentDao {
    void save(TravelDocument travelDocument);

    void validateTicket(Long id, Vehicle place) throws Exception;

    Long ticketsPerVehicle(Long vehicleId);
}
