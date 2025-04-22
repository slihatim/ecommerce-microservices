package com.ecommerce.customerservice.services;

import com.ecommerce.customerservice.controllers.CustomerController;
import com.ecommerce.customerservice.exceptions.CustomerNotFoundException;
import com.ecommerce.customerservice.models.Customer;
import com.ecommerce.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public String createCustomer(Customer request){
        var customer = customerRepository.save(request);
        return customer.getId();
    }

    public void updateCustomer(Customer customer){
        var customerToUpdate = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Cannot update customer:: No Customer found with the ID:: %s", customer.getId())));

        if(customer.getFirstName() != null)    customerToUpdate.setFirstName(customer.getFirstName());
        if(customer.getLastName() != null)    customerToUpdate.setLastName(customer.getLastName());
        if(customer.getEmail() != null)    customerToUpdate.setEmail(customer.getEmail());
        if(customer.getAddress() != null)    customerToUpdate.setAddress(customer.getAddress());

        customerRepository.save(customerToUpdate);
    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Boolean existsById(String customerId) {
        return customerRepository.existsById(customerId);
    }

    public Customer findById(String id){
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException(String.format("Cannot update customer:: No Customer found with the ID:: %s", id))
        );
    }

    public void deleteById(String id){
        customerRepository.deleteById(id);
    }
}
