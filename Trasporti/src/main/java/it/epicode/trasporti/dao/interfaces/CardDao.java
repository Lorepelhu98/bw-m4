package it.epicode.trasporti.dao.interfaces;

import it.epicode.trasporti.entities.Card;

public interface CardDao {


    void save(Card card);

    Card findCardById(Long id);

    void renewCard(Long id) throws Exception;
}
