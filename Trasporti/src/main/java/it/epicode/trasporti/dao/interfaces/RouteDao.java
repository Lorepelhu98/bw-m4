package it.epicode.trasporti.dao.interfaces;

import it.epicode.trasporti.entities.tranports.Route;

public interface RouteDao {
    void save(Route route);

    Route findRouteById(Long id);

    int calculateAvgTime(Long routeId);

    void updateAvgTime(Long routeId);
}
