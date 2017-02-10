package net.employees.service;

import net.employees.model.User;

/**
 * Created by dm4x on 05.02.17.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
