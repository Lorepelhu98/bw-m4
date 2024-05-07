package it.epicode.trasporti.dao;

import it.epicode.trasporti.entities.tranports.Transport;

public interface TransportDao {
    void save(Transport transport);

    Transport findTransportById(Long id);
}
