package com.example.demojdbc.controller.model.model.model.controller;

import com.example.demojdbc.controller.model.model.model.entity.Customer;
import com.example.demojdbc.controller.model.model.model.model.CustomerModel;
import com.example.demojdbc.controller.model.model.model.model.MySqlCustomerModel;
import com.example.demojdbc.controller.model.model.model.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateCustomerServlet extends HttpServlet {

    private CustomerModel customerModel;

    public CreateCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customer", new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customer/form.jsp").forward(req, resp);
        super.doGet(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String rollNumber = req.getParameter("rollNumber");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String stringBirthday = req.getParameter("birthday");
        System.out.println(fullName);
        LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
        Customer customer = new Customer(rollNumber, fullName, email, phone, birthday);
        // validate dữ liệu
        if (customerModel.save(customer) != null) {
            resp.sendRedirect("/admin/students/list");
        } else {
            req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
        }
    }


}
