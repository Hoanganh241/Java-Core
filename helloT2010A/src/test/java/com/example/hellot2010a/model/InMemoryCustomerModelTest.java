package com.example.hellot2010a.model;

import com.example.hellot2010a.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class InMemoryCustomerModelTest {

    InMemoryCustomerModel model;

    @BeforeEach
    void setUp() {
        model = new InMemoryCustomerModel();
    }

    @Test
    void save() {
        System.out.println(model.findAll().size());
        Customer customer = new Customer(
                "a12",
                "Hoang Anh",
                "hbbb",
                LocalDateTime.of(2000,10,10,0,0)
        );
        model.save(customer);
        System.out.println(model.findAll().size());
    }

    @Test
    void findAll() {
        System.out.println(model.findAll().size());
    }

    @Test
    void findById() {
        
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}