package net.employees.service;

import net.employees.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dm4x on 02.02.17.
 */

public interface EmployeeService {
    void save (Employee employee);

    void delete (Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> listEmployees();
}
