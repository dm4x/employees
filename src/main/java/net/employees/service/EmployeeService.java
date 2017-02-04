package net.employees.service;

import net.employees.model.Employee;

import java.util.List;

/**
 * Created by dm4x on 02.02.17.
 */
public interface EmployeeService {
    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(int id);

    public Employee getEmployeeById(int id);

    public List<Employee> listEmployees();
}
