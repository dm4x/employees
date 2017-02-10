package net.employees.service;

/**
 * Created by dm4x on 05.02.17.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
