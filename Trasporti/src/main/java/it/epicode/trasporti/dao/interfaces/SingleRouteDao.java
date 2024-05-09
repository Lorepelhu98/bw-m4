package it.epicode.trasporti.dao.interfaces;

import it.epicode.trasporti.entities.tranports.SingleRoute;
import it.epicode.trasporti.exceptions.VehicleUnderMaintenanceException;

public interface SingleRouteDao {
    void save(SingleRoute sr);

    void generateSingleRoute(SingleRoute sr) throws VehicleUnderMaintenanceException;

    Long routesPerVehicle(Long routeId, Long vehicleId);
}
