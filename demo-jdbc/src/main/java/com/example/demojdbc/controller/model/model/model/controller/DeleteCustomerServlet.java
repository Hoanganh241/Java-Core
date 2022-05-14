package com.example.demojdbc.controller.model.model.model.controller;

import com.example.demojdbc.controller.model.model.model.entity.Customer;
import com.example.demojdbc.controller.model.model.model.model.CustomerModel;
import com.example.demojdbc.controller.model.model.model.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCustomerServlet extends HelloServlet{

    private CustomerModel customerModel;

    public DeleteCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Lay tham so rollNumber(id)
        String rollNumber  = req.getParameter("id");
        //Kiem tra trong database co ton tai tham so truyen vao hay khong.
        Customer customer = customerModel.findById("rollNumber");
        //neu khong tra ve trang 404
        if (customer == null) {
            req.setAttribute("message", "Student not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp");
        } else {
            boolean result = customerModel.delete(rollNumber); //xoa mem
            if(result){
                resp.sendRedirect("/admin/customers/list");
            } else {
                req.setAttribute("message", "Action fails!");

                req.getRequestDispatcher("/admin/errors/500.jsp");
            }

        }
    }
}
