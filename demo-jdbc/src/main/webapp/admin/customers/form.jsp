<%@ page import="com.example.demojdbc.controller.model.model.model.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/5/2022
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
    int action = (int) request.getAttribute("action");
    String url = "/admin/customers/create";
    if(action == 2){
        url = "/admin/customers/edit";
    }
%>
<html>
<head>
    <title>Create new customer</title>
</head>
<body> <h1>Create customer</h1>
<a href="/admin/customers/list">Back to list</a>
<form action="<%=url%>" method="post">
    <div>Rollnumber
        <input type="text" name="rollNumber" value="<%=customer.getRollNumber()%>" <%=action == 2 ? "readonly":""%>></div>
    <div>Fullname <input type="text" name="fullName" value="<%=customer.getFullName()%>"></div>
    <div>Email <input type="email" name="email" value="<%=customer.getEmail()%>"></div>
    <div>Phone <input type="text" name="phone" value="<%=customer.getPhone()%>"></div>
    <div>Birthday <input type="date" name="birthday" value="<%=customer.getDobString()%>"></div>
    <div>
        <input type="submit" value="Save">
        <input type="reset" value="Reset">
    </div>
</form>
</body>
</html>
