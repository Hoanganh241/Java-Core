package com.example.demojdbc.controller.model.model.model.model;

import com.example.demojdbc.controller.model.model.model.entity.Customer;

import java.util.List;

public interface CustomerModel {

    Customer save(Customer customer);
    List<Customer> findAll();
    Customer findById(String rollNumber);
    Customer update(String rollNumber, Customer updateCustomer);
    boolean delete(String rollNumber);
}
