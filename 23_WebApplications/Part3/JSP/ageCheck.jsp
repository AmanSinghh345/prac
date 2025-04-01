<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    String name = request.getParameter("name");
    String ageStr = request.getParameter("age");
    if(name != null && ageStr != null){
        int age = Integer.parseInt(ageStr);
%>
<html>
<head><title>Age Check Result</title></head>
<body>
<% if(age < 18) { %>
    Hello <%= name %>, you are not authorized to visit the site.
<% } else { %>
    Welcome <%= name %> to this site.
<% } %>
</body>
</html>
<%
    } else {
%>
<html>
<head><title>Age Check</title></head>
<body>
    <form method="get" action="ageCheck.jsp">
        Name: <input type="text" name="name" required><br><br>
        Age: <input type="number" name="age" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
<%
    }
%>
