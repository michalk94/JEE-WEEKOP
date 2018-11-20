package pl.javastart.weekop.dao;

import pl.javastart.weekop.model.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    List<User> getAll();

    User getUserByUsername(String username);
}
