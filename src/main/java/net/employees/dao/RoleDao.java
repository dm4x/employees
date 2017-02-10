package net.employees.dao;

/**
 * Created by dm4x on 05.02.17.
 */
import net.employees.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
