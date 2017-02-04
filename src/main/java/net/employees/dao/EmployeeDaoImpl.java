package net.employees.dao;

import net.employees.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dm4x on 02.02.17.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(employee);
        logger.info("successfully saved " + employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(employee);
        logger.info("sucessfully updatetd " + employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        if (employee!=null) {
            session.delete(employee);
        }
        logger.info("sucessfully deleted " + employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.load(Employee.class, new Integer(id));
        logger.info("sucessfully loaded " + employee);
        return employee;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> listEmployees() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createQuery("from Employee").list();

        for (Employee employee : employeeList){
            logger.info("employee list: " + employee);
        }
        return employeeList;
    }
}
