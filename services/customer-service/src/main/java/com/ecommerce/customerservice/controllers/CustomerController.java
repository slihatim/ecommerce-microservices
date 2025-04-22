package com.ecommerce.customerservice.controllers;

import com.ecommerce.customerservice.models.Customer;
import com.ecommerce.customerservice.services.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid Customer customer){
        return ResponseEntity.ok( customerService.createCustomer(customer) );
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid Customer customer){
        customerService.updateCustomer(customer);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<Customer>> findAllCustomers(){
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/exists/{customerId}")
    public ResponseEntity<Boolean> existsById(@PathVariable String customerId){
        return ResponseEntity.ok( customerService.existsById(customerId) );
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findById(@PathVariable String customerId){
        return ResponseEntity.ok( customerService.findById(customerId) );
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
        customerService.deleteById(customerId);
        return ResponseEntity.ok(customerId);

    }
}
