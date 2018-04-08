<%-- 
    Document   : password_reset
    Created on : Mar 30, 2018, 11:21:36 AM
    Author     : Rose
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!DOCTYPE html>
        <h2>Password Reset</h2>
    <p>To reset your password, please enter the information below.</p>       
        <form action="LoginServlet" method="post">
            <input type="hidden" name="action" value="pw_reset"> 
            <label class="pad_top">New Password:</label> 
            <input type="password" name="password" value="$(user.password)" required><br>
            <br>
             <label>&nbsp;</label>
            <input type="submit" value="Submit" class="margin_left">
        </form>
<c:import url="/includes/footer.jsp" />

