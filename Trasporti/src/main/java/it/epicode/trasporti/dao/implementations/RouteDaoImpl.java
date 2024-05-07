package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.RouteDao;
import it.epicode.trasporti.entities.tranports.Route;
import jakarta.persistence.NoResultException;

public class RouteDaoImpl extends BaseDao implements RouteDao {

    @Override
    public void save(Route route){
        try{
            log.debug("Saving {}", route);
            var t = em.getTransaction();
            t.begin();
            em.persist(route);
            log.debug("Before commit {}", route);
            t.commit();
            log.debug("After commit {}", route);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

    @Override
    public Route findRouteById(Long id){
        try{
            return em.createQuery("SELECT r FROM Route r WHERE r.id =:id", Route.class)
                    .setParameter("id",id)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public int calculateAvgTime(Long routeId) {
        try {
            Double avgTime = em.createQuery("SELECT AVG(r.travelTime) FROM SingleRoute r WHERE r.route.id = :id GROUP BY r.route.id", Double.class)
                    .setParameter("id", routeId)
                    .getSingleResult();
            return avgTime != null ? (int) Math.round(avgTime) : 0;
        } catch (NoResultException ex) {
            return 0;
        }
    }

    @Override
    public void updateAvgTime(Long routeId) {

        int newAvgTime = calculateAvgTime(routeId);
        var t = em.getTransaction();

        try {
            t.begin();

            Route route = em.find(Route.class, routeId);
            if (route != null) {
                route.setAvgTime(newAvgTime);
                em.merge(route);
            }

            t.commit();
        } catch (Exception e) {

            if (t.isActive()) {
                t.rollback();
            }
            e.printStackTrace();
        }
    }

}
