package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.SingleRouteDao;
import it.epicode.trasporti.entities.tranports.SingleRoute;

public class SingleRouteDaoImpl extends BaseDao implements SingleRouteDao {

    @Override
    public void save(SingleRoute sr){
        try{
            log.debug("Saving {}", sr);
            var t = em.getTransaction();
            t.begin();
            em.persist(sr);
            log.debug("Before commit {}", sr);
            t.commit();
            log.debug("After commit {}", sr);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

}
