package it.epicode.trasporti.dao.implementations;

import it.epicode.trasporti.dao.BaseDao;
import it.epicode.trasporti.dao.interfaces.UserDao;
import it.epicode.trasporti.entities.Card;
import it.epicode.trasporti.entities.User;
import jakarta.persistence.NoResultException;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public void save(User user){
        try{
            log.debug("Saving {}", user);
            var t = em.getTransaction();
            t.begin();
            em.persist(user);
            log.debug("Before commit {}", user);
            t.commit();
            log.debug("After commit {}", user);
        } catch (Exception e){
            log.error("Exception saving entity...", e);
        }
    }

    @Override
    public User findUserById(Long id){
        try{
            return em.createQuery("SELECT u FROM User u WHERE u.id =:id", User.class)
                    .setParameter("id",id)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    //Metodo per generare un nuovo utente e la tessera che vi viene assegnata
    // alla creazione.

    @Override
    public void generateUser(User user){
        save(user);
        CardDaoImpl cardDao = new CardDaoImpl();
        Card card = new Card(user);
        cardDao.save(card);
    }


}
