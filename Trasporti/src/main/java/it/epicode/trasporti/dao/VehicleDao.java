package it.epicode.trasporti.dao;

import it.epicode.trasporti.entities.tranports.Vehicle;

public interface VehicleDao {
    void save(Vehicle transport);

    Vehicle findTransportById(Long id);
}
