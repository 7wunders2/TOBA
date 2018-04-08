<%-- 
    Document   : Login
    Created on : Apr 1, 2018, 1:18:00 PM
    Author     : Rose
--%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!DOCTYPE html>
        <h2>Login In or Register</h2>
        <form action="LoginServlet" method="post">
            <input type="hidden" name="action" value="authorize"> 
            <label class="pad_top">Username:</label>           
            <input type="text" name="username" required><br>
            <label class="pad_top">Password:</label> 
            <input type="password" name="password" required><br>
            <br>
             <label>&nbsp;</label>
            <input type="submit" value="Sign In" class="margin_left">
        </form>
            <br><br>
        <a href="password_reset.jsp">Reset password</a>
        <br><br>
        <a href="New_customer.jsp">New customer? Click here to Sign Up</a>

<c:import url="/includes/footer.jsp" />
