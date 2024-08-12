package com.demo.en.customerservice.service;

import com.demo.en.customerservice.exception.CustomerNotFoundException;
import com.demo.en.customerservice.model.Customer;
import com.demo.en.customerservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerById(Long id) {
        logger.info("Fetching customer by ID: {}", id);
        return customerRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Customer not found with ID: {}", id);
                    return new CustomerNotFoundException("Customer not found with ID: " + id);
                });
    }
    public List<Customer> searchCustomers(String lastName, LocalDate dateOfBirth, String firstName, String zipCode) {
        logger.info("Searching customers with provided parameters");
        if (lastName != null && dateOfBirth != null) {
            logger.debug("Search by lastName and dateOfBirth");
            return customerRepository.findByLastNameAndDateOfBirth(lastName, dateOfBirth);
        } else if (lastName != null && firstName != null && zipCode != null) {
            logger.debug("Search by lastName, firstName, and zipCode");
            return customerRepository.findByLastNameAndFirstNameAndZipCode(lastName, firstName, zipCode);
        } else {
            logger.warn("Invalid search parameters");
            throw new IllegalArgumentException("Invalid search parameters");
        }
    }
}