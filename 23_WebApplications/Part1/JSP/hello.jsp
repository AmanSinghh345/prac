<%@ page language="java" import="java.util.*, java.text.*" session="true" %>
<%
    if(request.getMethod().equalsIgnoreCase("POST")){
        session.setAttribute("name", request.getParameter("name"));
        session.setAttribute("start_time", System.currentTimeMillis());
    }
    String name = (String) session.getAttribute("name");
    long startTime = (Long) session.getAttribute("start_time");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String startTimeStr = sdf.format(new Date(startTime));
%>
<html>
<head>
    <title>Hello <%= name %></title>
    <style>
        .top-right { position: absolute; top: 10px; right: 10px; }
    </style>
</head>
<body>
    <div class="top-right">Start Time: <%= startTimeStr %></div>
    <h1>Hello <%= name %></h1>
    <form action="logout.jsp" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
