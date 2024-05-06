package it.epicode.trasporti.dao;

import it.epicode.trasporti.entities.Card;

public class CardDaoImpl extends BaseDao implements CardDao{

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

}
