package com.example.hellot2010a.model;

import com.example.hellot2010a.entity.Customer;
import com.example.hellot2010a.util.ConnectionHelper;

import javax.naming.PartialResultException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCustomerModel implements CustomerModel {

    public MySqlCustomerModel() {
        super();
    }

    @Override
    public Customer save(Customer customer) {
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "ínsert into customers " +
                    "(id, name, phone, image, dob, createdat, updateat, status) " +
                    " values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            PreparedStatement.setString(1, customer.getId());
            PreparedStatement.setString(2, customer.getName());
            PreparedStatement.setString(3, customer.getPhone());
            PreparedStatement.setString(4, customer.getImage()), preparedStatement.setString(5, student.getDob().toString());
            preparedStatement.setString(6, customer.getCreatedAt().toString());
            preparedStatement.setString(7, customer.getUpdatedAt().toString());
            preparedStatement.setInt(8, customer.getStatus());
            System.out.println("COnnection success!");
            preparedStatement.execute();
            return  customer;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "SELECT * FFROM customers WHERE STATUS = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String Id = resultSet.getString("id");
                String Name = resultSet.getString("name");
                String Phone= resultSet.getString("phone");
                String Image = resultSet.getString("image"); LocalDateTime dob =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("dob").toInstant(), ZoneId.systemDefault());
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Customer customer = new Customer(Id, Name, Phone, Image, dob, createdAt, updatedAt, status);
                list.add(customer);
            }
        }
        return null;
    }

    @Override
    public Customer findById(String Phone) {
        return null;
    }

    @Override
    public Customer update(String Name, Customer updateCustomer) {
        return null;
    }

    @Override
    public boolean delete(String Phone) {
        return false;
    }
}
