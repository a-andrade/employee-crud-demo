package com.springboot.employeecruddemo.rest;

import com.springboot.employeecruddemo.entity.Employee;
import com.springboot.employeecruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // @RequestBody ... to handle employee data coming in as json in the request body
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // set id to 0 ... just in case they pass an id in json
        // this is to force a save of a new item ... instead of an update
        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }

    // @RequestBody ... to handle employee data coming in as json in the request body
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        employeeService.save(theEmployee);

        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee with id - " + employeeId;
    }
}
