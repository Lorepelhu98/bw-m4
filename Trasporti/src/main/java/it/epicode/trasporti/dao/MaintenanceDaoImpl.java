package it.epicode.trasporti.dao;

import it.epicode.trasporti.entities.tranports.Maintenance;

public class MaintenanceDaoImpl extends BaseDao implements MaintenanceDao{

    @Override
    public void save(Maintenance maintenance){
        try{
            log.debug("Saving {}", maintenance);
            var t = em.getTransaction();
            t.begin();
            em.persist(maintenance);
            log.debug("Before commit {}", maintenance);
            t.commit();
            log.debug("After commit {}", maintenance);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

}
