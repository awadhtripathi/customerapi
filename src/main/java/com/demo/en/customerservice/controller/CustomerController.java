package com.demo.en.customerservice.controller;

import com.demo.en.customerservice.exception.ApiResponse;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.demo.en.customerservice.model.Customer;
import com.demo.en.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RequestMapping("/v1/customers")
@Validated
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")

    public ResponseEntity<ApiResponse<Customer>> getCustomerById(@PathVariable @Min(value = 1, message = "ID must be a positive number") Long id) {
        logger.info("Received request to get customer by ID: {}", id);
        Customer customer = customerService.getCustomerById(id);
        ApiResponse<Customer> response = new ApiResponse<>("success", customer, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Customer>>> searchCustomers(
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String zipCode,
            @RequestParam(required = false) LocalDate dateOfBirth) {
        logger.info("Received request to search customers");
        List<Customer> customers = customerService.searchCustomers(lastName, dateOfBirth, firstName, zipCode);
        ApiResponse<List<Customer>> response = new ApiResponse<>("success", customers, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}