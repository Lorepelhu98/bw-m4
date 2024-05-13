package it.epicode.trasporti.dao.interfaces;

import it.epicode.trasporti.entities.User;

public interface UserDao {
    void save(User user);

    User findUserById(Long id);

    void generateUser(User user);
}
