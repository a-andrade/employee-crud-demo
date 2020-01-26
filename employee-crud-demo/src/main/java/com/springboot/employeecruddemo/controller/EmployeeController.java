package com.springboot.employeecruddemo.controller;

import com.springboot.employeecruddemo.entity.Employee;
import com.springboot.employeecruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    /*private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {

        Employee emp1 = new Employee(1, "Leslie", "Andrews", "leslie@yahoo.com");
        Employee emp2 = new Employee(2, "Robert", "English", "robert@gmail.com");
        Employee emp3 = new Employee(3, "Valdimar", "Aviles", "valdimar@yahoo.com");

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
    }*/

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
