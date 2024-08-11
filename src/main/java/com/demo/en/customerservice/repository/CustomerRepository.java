package com.demo.en.customerservice.repository;

import com.demo.en.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    List<Customer> findByLastNameAndDateOfBirth(String lastName, LocalDate dateOfBirth);

    List<Customer> findByLastNameAndFirstNameAndZipCode(String lastName, String firstName, String zipCode);
}
