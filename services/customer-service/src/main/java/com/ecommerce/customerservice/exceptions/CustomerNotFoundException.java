package com.ecommerce.customerservice.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message){
        super(message);
    }

}
