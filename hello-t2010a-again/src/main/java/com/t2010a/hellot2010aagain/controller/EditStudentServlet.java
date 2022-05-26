package com.t2010a.hellot2010aagain.controller;

import com.t2010a.hellot2010aagain.entity.Student;
import com.t2010a.hellot2010aagain.model.MySqlStudentModel;
import com.t2010a.hellot2010aagain.model.StudentModel;
import com.t2010a.hellot2010aagain.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class EditStudentServlet extends HttpServlet {

    private StudentModel studentModel;

    public EditStudentServlet() {
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
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String rollNumber = req.getParameter("rollNumber");
        Student existingStudent = studentModel.findById(rollNumber);
        if(existingStudent == null){
            req.setAttribute("message", "Student not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else{
            String fullName = req.getParameter("fullName");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String stringBirthday = req.getParameter("birthday");
            System.out.println(fullName);
            LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
            Student student = new Student(rollNumber, fullName, email, phone, birthday);
            // validate dữ liệu
            if (studentModel.update(rollNumber, student) != null) {
                resp.sendRedirect("/admin/students/list");
            } else {
                // nếu có trả về trang form
                req.setAttribute("student", student);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/students/form.jsp").forward(req, resp);
            }
        }
    }
}
