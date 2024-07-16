package com.sergiozavaleta.company.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    Integer id;
    String firstname;
    String lastname;
    String email;
    String address;
    
   
    
}
