package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.RouteDao;
import it.epicode.trasporti.entities.tranports.Route;
import it.epicode.trasporti.entities.tranports.SingleRoute;
import jakarta.persistence.NoResultException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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

}
