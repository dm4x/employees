package net.employees.dao;

/**
 * Created by dm4x on 05.02.17.
 */
import net.employees.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
