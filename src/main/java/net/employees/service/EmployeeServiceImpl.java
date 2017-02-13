package net.employees.service;

import net.employees.dao.EmployeeDao;
import net.employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dm4x on 02.02.17.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void delete(Employee employee){
        employeeDao.delete(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        return employeeDao.findAll();
    }
}
