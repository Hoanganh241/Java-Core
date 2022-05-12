package com.example.hellot2010a.model;

import com.example.hellot2010a.entity.Customer;
import org.glassfish.jersey.internal.inject.Custom;

import java.util.List;

public interface CustomerModel {
    Customer save(Customer customer); // lưu thông tin.

    List<Customer> findAll();

    Customer findById(String Phone);

    Customer update(String Name, Customer updateCustomer);

    boolean delete(String Phone);
}
