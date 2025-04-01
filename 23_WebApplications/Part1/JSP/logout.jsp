<%@ page language="java" import="java.util.*" session="true" %>
<%
    String name = (String) session.getAttribute("name");
    long startTime = (Long) session.getAttribute("start_time");
    long endTime = System.currentTimeMillis();
    long duration = (endTime - startTime) / 1000;
    session.invalidate();
%>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <h1>Thank You <%= name %></h1>
    <p>Duration of usage: <%= duration %> seconds.</p>
</body>
</html>
