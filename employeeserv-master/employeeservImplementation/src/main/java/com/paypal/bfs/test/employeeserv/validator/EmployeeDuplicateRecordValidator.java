package com.paypal.bfs.test.employeeserv.validator;

import com.paypal.bfs.test.employeeserv.api.entity.Address;
import com.paypal.bfs.test.employeeserv.api.entity.Employee;
import com.paypal.bfs.test.employeeserv.api.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.api.request.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.exception.EmployeeException;
import com.paypal.bfs.test.employeeserv.helper.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDuplicateRecordValidator {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeHelper helper;

    public Employee getEmployeeIfExists(EmployeeRequest employee, List<Employee> employees) {
        try {
            return helper.getEmployeeIfExists(employee, employees);
        } catch (Exception ex) {
            throw new EmployeeException(ex.getMessage());
        }
    }

    public Address getAddressIfExists(EmployeeRequest employee, List<Employee> employees) {
        try {
            return helper.getAddressIfExists(employee, employees);
        } catch (Exception ex) {
            throw new EmployeeException(ex.getMessage());
        }
    }

    public boolean isDuplicateRecordPresent(EmployeeRequest employee, List<Employee> employees) {
        try {
            return helper.isDuplicateRecordPresent(employee, employees);
        } catch (Exception ex) {
            throw new EmployeeException(ex.getMessage());
        }
    }
}
