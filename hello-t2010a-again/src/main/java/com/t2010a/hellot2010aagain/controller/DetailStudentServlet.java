package com.t2010a.hellot2010aagain.controller;

import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.model.MySqlStudentModel;
import com.t2010a.hellot2010aagain.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailStudentServlet extends HttpServlet {

    private StudentModel studentModel;

    public DetailStudentServlet() {
        this.studentModel = new MySqlStudentModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số rollNumber(id)
        String rollNumber = req.getParameter("id");
        // kiểm tra trong database xem có tồn tại không.
        Student student = studentModel.findById(rollNumber);
        // nếu không trả về trang 404
        if (student == null) {
            req.setAttribute("message", "Student not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        } else {
            // nếu có trả về trang detail
            req.setAttribute("student", student);
            req.getRequestDispatcher("/admin/students/detail.jsp").forward(req, resp);
        }

    }
}
