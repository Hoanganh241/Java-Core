package com.example.demojdbc.controller.model.model.model.controller;

import com.example.demojdbc.controller.model.model.model.entity.Customer;
import com.example.demojdbc.controller.model.model.model.model.CustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public DetailCustomerServlet(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lay thham so rollNumber(id)
        String rollNumber = req.getParameter("id");
        //Kiem tra xem tham so truyen vao co ton tai khong.
        Customer customer = customerModel.findById("rollNumer");
        //Neu tham so truyen vao khong ton tai thi tra ve trang 404
        if (customer == null){
            req.setAttribute("message", "Customer not found");
            req.getRequestDispatcher("/admin/errors/404/jsp");
        } else {
            //Neu tham so truyen vao ton tai thi tra ve trang detail
            req.setAttribute("customer", customer);
            req.getRequestDispatcher("/admin/customers/detail");
        }
    }
}
