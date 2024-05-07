package it.epicode.trasporti.dao;

import it.epicode.trasporti.entities.tranports.Transport;
import jakarta.persistence.NoResultException;

public class TransportDaoImpl extends BaseDao implements TransportDao{

    @Override
    public void save(Transport transport){
        try{
            log.debug("Saving {}", transport);
            var t = em.getTransaction();
            t.begin();
            em.persist(transport);
            log.debug("Before commit {}", transport);
            t.commit();
            log.debug("After commit {}", transport);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

    @Override
    public Transport findTransportById(Long id){
        try{
            return em.createQuery("SELECT t FROM Transport t WHERE t.id =:id", Transport.class)
                    .setParameter("id",id)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

}
