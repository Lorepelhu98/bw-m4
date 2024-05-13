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

    //Funzione per trovare un oggetto di tipo Card partendo dall'id fornito.
    @Override
    public Card findCardById(Long id){
        try{
            return em.find(Card.class, id);
        } catch (NoResultException e){
            return null;
        }
    }

    //Metodo per rinnovare la tessera utente. La tessera ha scadenza annuale,
    //questo metodo aggiorna la data dell'ultimo rinnovo alla data attuale,
    // e la data di scadenza di conseguenza viene spostata ad un'anno da oggi
    @Override
    public void renewCard(Long id) throws Exception {
        LocalDate newRenewalDate = LocalDate.now();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Card card = em.find(Card.class, id);
            if (card != null) {
                card.setRenewalDate(newRenewalDate); //aggiorno data di rinnovo
                card.setExpirationDate(newRenewalDate.plusYears(1)); //setto data di scadenza di conseguenza
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
