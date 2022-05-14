<%@ page import="com.example.demojdbc.controller.model.model.model.entity.Customer" %><%--

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/5/2022
  Time: 2:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    Customer customer = (Customer)request.getAttribute("customer");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customer Detail</title>
</head>
<body>
<h1>Customer Detail</h1>
<a href="/admin/customers/list">Back to list</a>
<a href="/admin/customers/creat">Create new customer</a>
<div>
    Rollnumber: <%=customer.getRollNumber()%>
</div>
<div>
    Fullname: <%=customer.getFullName()%>
</div>

</body>
</html>