package net.employees.controller;

import net.employees.model.Employee;
import net.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dm4x on 03.02.17.
 */
@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    public void setEmployeeservice(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employees";
    }

    @RequestMapping(value = "employees/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee){
        if (employee.getId() == 0){
            this.employeeService.addEmployee(employee);
        } else {
            this.employeeService.updateEmployee(employee);
        }
        return "redirect:/employees";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        this.employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @RequestMapping("edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployees());
        return "employees";
    }

    @RequestMapping("employeedata/{id}")
    public String employeeData(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        return "employeedata";
    }
}
