package net.employees.service;

import net.employees.dao.EmployeeDao;
import net.employees.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dm4x on 02.02.17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        this.employeeDao.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        this.employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        this.employeeDao.deleteEmployee(id);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return this.employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        return this.employeeDao.listEmployees();
    }
}
