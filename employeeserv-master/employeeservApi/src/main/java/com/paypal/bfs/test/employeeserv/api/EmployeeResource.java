package com.paypal.bfs.test.employeeserv.api;

import com.paypal.bfs.test.employeeserv.api.entity.Employee;
import com.paypal.bfs.test.employeeserv.api.request.EmployeeRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Interface for employee resource operations.
 */
@RequestMapping("/v1/bfs")
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @RequestMapping(value = "/employees/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<?> employeeGetById(@PathVariable("id") String id);

    @RequestMapping("/retrieve-all-employee")
    ResponseEntity<?> retrieveAllEmployee();

    @RequestMapping(value = "/create-employee",
            method = RequestMethod.POST,
           consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeRequest employee);
}
