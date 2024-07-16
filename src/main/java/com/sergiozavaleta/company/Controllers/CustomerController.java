package com.sergiozavaleta.company.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiozavaleta.company.Entities.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final List<Customer> customers;
    
    
    public CustomerController() {
        customers = new ArrayList<>();
        customers.add(new Customer(1,"Jose","Pelaez","jose@test.com","Las Lomas 123"));
        customers.add(new Customer(2,"Pedro","Garcia","pedro@test.com","Las Lomas 789"));
        customers.add(new Customer(3,"Manuel","Gomez","manuel@test.com","Las Lomas 130"));
        customers.add(new Customer(4,"Andres","Carmona","andres@test.com","Las Lomas 140"));
        customers.add(new Customer(5,"Gonzalo","Tello","gonzalo@test.com","Las Lomas 150"));
    }

   

    @GetMapping()
    public List<Customer> findAll() {
        return customers;
    }

    @GetMapping("/{id}")
    public Customer find(@PathVariable("id") Integer id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @PostMapping()
    public Integer create(@RequestBody Customer customer) {
       customers.add(customer);
       return customer.getId();
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable("id") Integer id, @RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                customers.remove(c);
                customers.add(customer);
                return customer;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                customers.remove(customer);
                return id;
            }
        }
        return null;
       
    }
}
