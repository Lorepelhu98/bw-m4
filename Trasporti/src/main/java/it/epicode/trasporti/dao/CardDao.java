package it.epicode.trasporti.dao;

import it.epicode.trasporti.entities.Card;

public interface CardDao {


    void save(Card card);

    Card findCardById(Long id);
}
