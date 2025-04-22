package com.ecommerce.customerservice.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Customer {
    @Id
    private String id;

    @NotBlank(message = "first name is required")
    private String firstName;

    @NotBlank(message = "last name is required")
    private String lastName;

    @Email(message = "Customer email is not valid")
    private String email;

    private Address address;

}
