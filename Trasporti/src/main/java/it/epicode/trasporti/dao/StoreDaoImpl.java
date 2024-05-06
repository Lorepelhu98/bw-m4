package it.epicode.trasporti.dao;

import it.epicode.trasporti.entities.Store;

public class StoreDaoImpl extends BaseDao implements StoreDao{

    @Override
    public void save(Store store){
        try{
            log.debug("Saving {}", store);
            var t = em.getTransaction();
            t.begin();
            em.persist(store);
            log.debug("Before commit {}", store);
            t.commit();
            log.debug("After commit {}", store);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

}
