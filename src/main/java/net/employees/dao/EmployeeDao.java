package net.employees.dao;

import net.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dm4x on 02.02.17.
 */
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    Employee getEmployeeById(Long id);
    List<Employee> findAll();
}
