<%-- 
    Document   : New_customer
    Created on : Mar 18, 2018, 1:52:04 PM
    Author     : Rose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Customer Registration</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Titan Online Banking</h1>
            <nav>
              <a href="index.html">Home</a> &nbsp; 
              <a href="Login.html">Login</a>
            </nav>
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
    </body>
</html>
