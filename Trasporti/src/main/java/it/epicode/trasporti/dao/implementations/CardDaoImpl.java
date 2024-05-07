package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.CardDao;
import it.epicode.trasporti.entities.Card;
import jakarta.persistence.NoResultException;

public class CardDaoImpl extends BaseDao implements CardDao {

    @Override
    public void save(Card card){
        try{
            log.debug("Saving {}", card);
            var t = em.getTransaction();
            t.begin();
            em.persist(card);
            log.debug("Before commit {}", card);
            t.commit();
            log.debug("After commit {}", card);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

    @Override
    public Card findCardById(Long id){
        try{
            return em.createQuery("SELECT c FROM Card c WHERE c.id =:id", Card.class)
                    .setParameter("id",id)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

}
