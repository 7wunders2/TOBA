<%-- 
    Document   : footer
    Created on : Mar 30, 2018, 11:24:28 AM
    Author     : Rose
--%>   
<%@ page import="java.util.GregorianCalendar, java.util.Calendar" %>
<%  
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
    int currentMonth = currentDate.get(Calendar.MONTH) + 1;
    int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);
 %>
 <br><br><br>
<p>&copy; Copyright <%= currentMonth %>-<%= currentDay %>-<%= currentYear %> Titan Online Banking</p>
</body>
</html>
