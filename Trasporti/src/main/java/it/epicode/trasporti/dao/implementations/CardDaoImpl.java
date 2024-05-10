package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.CardDao;
import it.epicode.trasporti.entities.Card;
import it.epicode.trasporti.entities.User;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.time.LocalDate;

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
            return em.find(Card.class, id);
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void renewCard(Long id) throws Exception {
        LocalDate newRenewalDate = LocalDate.now();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Card card = em.find(Card.class, id);
            if (card != null) {
                card.setRenewalDate(newRenewalDate);
                card.setExpirationDate(newRenewalDate.plusYears(1));
                em.merge(card);
            } else {
                throw new IllegalArgumentException("Card not found with ID: " + id);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

}
