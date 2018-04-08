<%-- 
    Document   : Account_activity
    Created on : Apr 1, 2018, 1:14:09 PM
    Author     : Rose
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<!DOCTYPE html>
   <body>
        <h2>Account Activity</h2>
        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <p>Not logged In</p>  
            </c:when>
            <c:otherwise>
                <p>Welcome ${user.firstName} ${user.lastName}</p>
            </c:otherwise>
        </c:choose>

<c:import url="/includes/footer.jsp" />