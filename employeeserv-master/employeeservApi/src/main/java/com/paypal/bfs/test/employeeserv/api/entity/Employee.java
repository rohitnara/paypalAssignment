package com.paypal.bfs.test.employeeserv.api.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name", "address", "date_of_birth"})})
public class Employee {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column(name = "id")
        private Integer id;

        @Column(name = "first_name", length = 255, nullable = false)
        private String firstName;

        @Column(name = "last_name", length = 255, nullable = false)
        private String lastName;

        @ManyToOne
        @JoinColumn(name = "address", referencedColumnName = "id", nullable = false)
        private Address address;

        @Column(name = "date_of_birth", nullable = false)
        private LocalDate dob;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public Address getAddress() {
                return address;
        }

        public void setAddress(Address address) {
                this.address = address;
        }

        public LocalDate getDob() {
                return dob;
        }

        public void setDob(LocalDate dob) {
                this.dob = dob;
        }

        @Override
        public String toString() {
                return "Employee{" +
                        "id=" + id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", address=" + address +
                        ", dob=" + dob +
                        '}';
        }
}
