package com.paypal.bfs.test.employeeserv.helper;

import com.paypal.bfs.test.employeeserv.api.entity.Address;
import com.paypal.bfs.test.employeeserv.api.entity.Employee;
import com.paypal.bfs.test.employeeserv.api.request.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeHelper {

    public Employee getEmployeeIfExists(EmployeeRequest employee, List<Employee> employees) {
        Employee employeeRecord = null;
        for(Employee employeeResult : employees) {
            if(isSameEmployee(employeeResult, employee)) {
                employeeRecord = employeeResult;
                break;
            }
        }
        return employeeRecord;
    }

    public Address getAddressIfExists(EmployeeRequest employee, List<Employee> employees) {
        Address addressRecord = null;
        for(Employee employeeResult : employees) {
            if(isSameAddress(employeeResult, employee)) {
                addressRecord = employeeResult.getAddress();
                break;
            }
        }
        return addressRecord;
    }


    public boolean isDuplicateRecordPresent(EmployeeRequest employee, List<Employee> employees) {
        boolean isDuplicateResult = false;
        for(Employee employeeResult : employees) {
            if(isSameAddress(employeeResult, employee) && isSameEmployee(employeeResult, employee)) {
                isDuplicateResult = true;
                break;
            }
        }
        return isDuplicateResult;
    }

    private boolean isSameAddress(Employee employeeResult, EmployeeRequest employee) {
        return employeeResult.getAddress().getLine1().equalsIgnoreCase(employee.getAddress().getLine1())
                && employeeResult.getAddress().getCity().equalsIgnoreCase(employee.getAddress().getCity())
                && employeeResult.getAddress().getCountry().equalsIgnoreCase(employee.getAddress().getCountry())
                && employeeResult.getAddress().getState().equalsIgnoreCase(employee.getAddress().getState())
                && employeeResult.getAddress().getZipcode().equals(employee.getAddress().getZipcode())
                && isAddressLine2Equal(employeeResult.getAddress().getLine2(),employee.getAddress().getLine2());
    }

    private boolean isSameEmployee(Employee employeeResult, EmployeeRequest employee) {
        return employeeResult.getFirstName().equalsIgnoreCase(employee.getFirstName())
                && employeeResult.getLastName().equalsIgnoreCase(employee.getLastName())
                && employeeResult.getDob().toString().equalsIgnoreCase(employee.getDob());
    }
    private boolean isAddressLine2Equal(String line1, String line2) {
        boolean isLine2Equal;
        if((line1 == null && line2 != null) || (line1 != null && line2 == null)) {
            isLine2Equal = false;
        } else if(line1 == null && line2 == null) {
            isLine2Equal = true;
        } else {
            isLine2Equal = line1.equalsIgnoreCase(line2);
        }
        return isLine2Equal;
    }

}
