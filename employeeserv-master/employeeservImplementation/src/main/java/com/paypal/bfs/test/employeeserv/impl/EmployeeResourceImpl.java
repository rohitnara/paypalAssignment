package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.entity.Address;
import com.paypal.bfs.test.employeeserv.api.entity.Employee;
import com.paypal.bfs.test.employeeserv.api.repository.AddressRepository;
import com.paypal.bfs.test.employeeserv.api.repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.api.request.EmployeeRequest;
import com.paypal.bfs.test.employeeserv.exception.DuplicateRecordException;
import com.paypal.bfs.test.employeeserv.exception.EmployeeException;
import com.paypal.bfs.test.employeeserv.exception.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.validator.EmployeeDuplicateRecordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.paypal.bfs.test.employeeserv.constants.Constants.*;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeDuplicateRecordValidator validator;

    @Override
    public ResponseEntity<?> employeeGetById(String id) {

        try {
            Optional<Employee> employee = employeeRepository.findById(Integer.valueOf(id));
            if(!employee.isPresent()) {
                throw new EmployeeNotFoundException(EMPLOYEE_NOT_PRESENT);
            }
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (EmployeeNotFoundException ex){
            throw ex;
        } catch (Exception ex) {
            throw new EmployeeException(ex.getMessage());
        }
    }

    public ResponseEntity<?> retrieveAllEmployee() {

        try {
            List<Employee> employees = employeeRepository.findAll();
            if(CollectionUtils.isEmpty(employees)) {
                throw new EmployeeNotFoundException(EMPLOYEE_NOT_PRESENT);
            }
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (EmployeeNotFoundException ex){
            throw ex;
        } catch (Exception ex) {
            throw new EmployeeException(ex.getMessage());
        }
    }

    @Transactional
    public ResponseEntity<?> createEmployee(EmployeeRequest employee) {
        try {
            List<Employee> employees = employeeRepository.findAll();
            if(validator.isDuplicateRecordPresent(employee, employees)) {
                throw new DuplicateRecordException(RECORD_ALREADY_PRESENT);
            }
            Employee employeeResult = validator.getEmployeeIfExists(employee, employees);
            Address addressResult = validator.getAddressIfExists(employee, employees);
            Employee employeeRecord = new Employee();
            LocalDate dob;
            try {
                dob = LocalDate.parse(employee.getDob());
            } catch (Exception ex) {
                throw new EmployeeException(WRONG_DOB_FORMAT);
            }
            if((employeeResult == null && addressResult == null)
                || (employeeResult != null && addressResult == null)) {               //employee and address both does not exist
                Address address = new Address();                                      // employee exists but address does not
                address.setLine1(employee.getAddress().getLine1());
                address.setLine2(employee.getAddress().getLine2());
                address.setCity(employee.getAddress().getCity());
                address.setCountry(employee.getAddress().getCountry());
                address.setState(employee.getAddress().getState());
                address.setZipcode(employee.getAddress().getZipcode());
                Address addressRecord = addressRepository.save(address);
                employeeRecord.setFirstName(employee.getFirstName());
                employeeRecord.setLastName(employee.getLastName());
                employeeRecord.setDob(dob);
                employeeRecord.setAddress(addressRecord);
            } else if((employeeResult == null && addressResult != null)
                    || (employeeResult != null && addressResult != null
                    && !employeeResult.getAddress().getId().equals(addressResult.getId()))) { //employee does not exist but address exists
                                                                                        // or employee and address both exist but
                employeeRecord.setFirstName(employee.getFirstName());                   //address is different for the employee
                employeeRecord.setLastName(employee.getLastName());
                employeeRecord.setDob(dob);
                employeeRecord.setAddress(addressResult);
            } else {
                throw new DuplicateRecordException(RECORD_ALREADY_PRESENT);
            }
            Employee employeeData = employeeRepository.save(employeeRecord);
            return new ResponseEntity<>(EMPLOYEE_CREATION_RESPONSE + employeeData.getId(), HttpStatus.OK);
        } catch (DuplicateRecordException ex) {
            throw ex;
        } catch (Exception ex){
            throw new EmployeeException(ex.getMessage());
        }
    }
}
