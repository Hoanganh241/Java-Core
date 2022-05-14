package com.example.demojdbc.controller.model.model.model.controller;

import com.example.demojdbc.controller.model.model.model.entity.Customer;
import com.example.demojdbc.controller.model.model.model.model.CustomerModel;
import com.example.demojdbc.controller.model.model.model.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class EditCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public EditCustomerServlet(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lay tham so rollNumber(id)
        String rollNumber = req.getParameter("id");
        //kiem tra xem tham so truyen vao co ton tai hay khong
        Customer customer = customerModel.findById(rollNumber);
        //Neu tham so truyen vao khong ton tai tra ve trang 404
        if (customer != null){
            req.setAttribute("customer", customer);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }else {
            req.setAttribute("message", "Customer is not ofund");
            req.getRequestDispatcher("/admin/errors/404.jps").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //xu ly validate va save
        String rollNumber = req.getParameter("rollNumber");
        Customer existingDispatcher = customerModel.findById(rollNumber);
        if (existingDispatcher == null) {
            req.setAttribute("message", "Student iis not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            String fullName = req.getParameter("fullName");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String stringBirhday = req.getParameter("birthday");
            System.out.println(fullName);
            LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirhday);
            Customer customer = new Customer(rollNumber, fullName, email, phone, birthday);
            //validate du lieu
            if (customerModel.update(rollNumber, customer) != null) {
                resp.sendRedirect("/admin/customers/list");
            }else {
                //neu co tra ve trang form
                req.setAttribute("customer", customer);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
            }
        }
    }
}
