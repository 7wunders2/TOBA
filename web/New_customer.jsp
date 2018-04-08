<%-- 
    Document   : New_customer
    Created on : Mar 18, 2018, 1:52:04 PM
    Author     : Rose
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!DOCTYPE html>
        <h2>New Customer Registration</h2>
    <p>To register for online banking, please enter the information below.</p>
    <p><i>${message}</i></p>
    <form action="NewCustomerServlet" method="post">
        <input type="hidden" name="action" value="add">        
        <label class="pad_top">First Name:</label>
        <input type="text" name="firstName" value="${user.firstName}"><br>
        <label class="pad_top">Last Name:</label>
        <input type="text" name="lastName" value="${user.lastName}"><br> 
        <label class="pad_top">Phone:</label>
        <input type="text" name="phone" value="${user.phone}"><br>
        <label class="pad_top">Address:</label>
        <input type="text" name="address" value="${user.address}"><br>
        <label class="pad_top">City:</label>
        <input type="text" name="city" value="${user.city}"><br>
        <label class="pad_top">State:</label>
        <input type="text" name="state" value="${user.state}"><br>
        <label class="pad_top">Zipcode:</label>
        <input type="text" name="zip" value="${user.zip}"><br>     
        <label class="pad_top">Email:</label>
        <input type="email" name="email" value="${user.email}"><br>
        <label>&nbsp;</label>
        <input type="submit" value="Register" class="margin_left">
    </form>
<c:import url="/includes/footer.jsp" />

