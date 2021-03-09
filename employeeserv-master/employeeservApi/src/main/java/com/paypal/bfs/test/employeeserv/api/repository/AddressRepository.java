package com.paypal.bfs.test.employeeserv.api.repository;

import com.paypal.bfs.test.employeeserv.api.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
