package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.StoreDao;
import it.epicode.trasporti.entities.User;
import it.epicode.trasporti.entities.stores.Store;
import jakarta.persistence.NoResultException;

public class StoreDaoImpl extends BaseDao implements StoreDao {

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

    public Store findStoreById(Long id){
        try{
            return em.createQuery("SELECT s FROM Store s WHERE s.id =:id", Store.class)
                    .setParameter("id",id)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

}
