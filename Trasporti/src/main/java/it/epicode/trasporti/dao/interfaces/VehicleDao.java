package it.epicode.trasporti.dao.interfaces;

import it.epicode.trasporti.entities.tranports.Vehicle;

public interface VehicleDao {
    void save(Vehicle vehicle);


    Vehicle findVehicleById(Long id);
}
