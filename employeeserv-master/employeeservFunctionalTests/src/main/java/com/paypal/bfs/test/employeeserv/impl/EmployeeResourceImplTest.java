package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.entity.Address;
import com.paypal.bfs.test.employeeserv.api.entity.Employee;
import com.paypal.bfs.test.employeeserv.api.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeResourceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeResourceImpl employeeResource;

    @Test
    public void employeeGetByIdTest() {
        when(employeeRepository.findById(1)).thenReturn(getEmployee(1));
        Assert.assertEquals(getExpectedEmployee().toString(), employeeResource.employeeGetById("1").getBody().toString());
    }

    @Test
    public void retrieveAllEmployeeTest() {
        when(employeeRepository.findAll()).thenReturn(getAllEmployee());
        Assert.assertEquals(getExpectedAllEmployee().toString(), employeeResource.retrieveAllEmployee().getBody().toString());
    }

    private List<Employee> getExpectedAllEmployee() {
        Address address1 = new Address();
        address1.setId(2);
        address1.setLine1("test");
        address1.setLine2("test");
        address1.setCity("test");
        address1.setCountry("test");
        address1.setState("test");
        address1.setZipcode(12345);
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setFirstName("Rohit");
        employee1.setLastName("Narayan");
        employee1.setAddress(address1);
        employee1.setDob(LocalDate.parse("1995-01-01"));
        Address address2 = new Address();
        address2.setId(2);
        address2.setLine1("test1");
        address2.setLine2("test1");
        address2.setCity("test1");
        address2.setCountry("test1");
        address2.setState("test1");
        address2.setZipcode(12346);
        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setFirstName("Prem");
        employee2.setLastName("Sinha");
        employee2.setAddress(address2);
        employee2.setDob(LocalDate.parse("1994-01-01"));
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        return employees;
    }

    private List<Employee> getAllEmployee() {
        Address address1 = new Address();
        address1.setId(2);
        address1.setLine1("test");
        address1.setLine2("test");
        address1.setCity("test");
        address1.setCountry("test");
        address1.setState("test");
        address1.setZipcode(12345);
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setFirstName("Rohit");
        employee1.setLastName("Narayan");
        employee1.setAddress(address1);
        employee1.setDob(LocalDate.parse("1995-01-01"));
        Address address2 = new Address();
        address2.setId(2);
        address2.setLine1("test1");
        address2.setLine2("test1");
        address2.setCity("test1");
        address2.setCountry("test1");
        address2.setState("test1");
        address2.setZipcode(12346);
        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setFirstName("Prem");
        employee2.setLastName("Sinha");
        employee2.setAddress(address2);
        employee2.setDob(LocalDate.parse("1994-01-01"));
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        return employees;
    }

    private Optional<Employee> getExpectedEmployee() {
        Address address = new Address();
        address.setId(2);
        address.setLine1("test");
        address.setLine2("test");
        address.setCity("test");
        address.setCountry("test");
        address.setState("test");
        address.setZipcode(12345);
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Rohit");
        employee.setLastName("Narayan");
        employee.setAddress(address);
        employee.setDob(LocalDate.parse("1995-01-01"));
        return Optional.of(employee);
    }

    private Optional<Employee> getEmployee(Integer id) {
        Address address = new Address();
        address.setId(2);
        address.setLine1("test");
        address.setLine2("test");
        address.setCity("test");
        address.setCountry("test");
        address.setState("test");
        address.setZipcode(12345);
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName("Rohit");
        employee.setLastName("Narayan");
        employee.setAddress(address);
        employee.setDob(LocalDate.parse("1995-01-01"));
        return Optional.of(employee);
    }
}
