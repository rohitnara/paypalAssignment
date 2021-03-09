package com.paypal.bfs.test.employeeserv.api.repository;

import com.paypal.bfs.test.employeeserv.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
