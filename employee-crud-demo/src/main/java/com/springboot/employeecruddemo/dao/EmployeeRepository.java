package com.springboot.employeecruddemo.dao;

import com.springboot.employeecruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Version #3 DAO Technique ...  using spring data JPA
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // boilerplate crud methods inherited for free ... so no extra work needed
    // also, no need for an implementation class

}
