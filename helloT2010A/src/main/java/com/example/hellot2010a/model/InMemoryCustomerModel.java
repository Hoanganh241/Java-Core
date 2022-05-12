package com.example.hellot2010a.model;

import com.example.hellot2010a.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel {

    private static List<Customer> customers;

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String Id) {
        Customer foundCustomer = null;
        for (Customer customer :
        customers) {
            if (customer.getId().equals(Id)) {
                foundCustomer = customer;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(String Id, Customer updateCustomer) {
        Customer existingCustomer = findById(Id);
        if (existingCustomer == null) {
            return null;
        }
        existingCustomer.setId(updateCustomer.getId());
        existingCustomer.setName(updateCustomer.getName());
        existingCustomer.setPhone(updateCustomer.getPhone());
        existingCustomer.setImage(updateCustomer.getImage());
        existingCustomer.setDob(updateCustomer.getDob());
        existingCustomer.setUpdatedAt(LocalDateTime.now());
        existingCustomer.setStatus(updateCustomer.getStatus());
        return existingCustomer;
    }
        @Override
    public boolean delete(String Id) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId().equals(Id)){
                foundIndex = i;
            }
        }
        if(foundIndex != -1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}