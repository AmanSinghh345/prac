<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%
    // Check if "user" cookie exists
    boolean userCookieExists = false;
    javax.servlet.http.Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(javax.servlet.http.Cookie cookie : cookies){
            if(cookie.getName().equals("user")){
                userCookieExists = true;
                break;
            }
        }
    }
    if(!userCookieExists) {
        javax.servlet.http.Cookie userCookie = new javax.servlet.http.Cookie("user", "JohnDoe");
        userCookie.setMaxAge(3600);
        response.addCookie(userCookie);
        javax.servlet.http.Cookie sessionCookie = new javax.servlet.http.Cookie("sessionID", "XYZ123");
        sessionCookie.setMaxAge(3600);
        response.addCookie(sessionCookie);
    }
%>
<html>
<head>
    <title>List Cookies</title>
</head>
<body>
    <form method="post" action="cookieList.jsp">
        <input type="submit" name="listCookies" value="List Cookies">
    </form>
<%
    if(request.getMethod().equalsIgnoreCase("POST")){
%>
    <h3>Cookies Stored:</h3>
    <ul>
<%
        cookies = request.getCookies();
        if(cookies != null){
            for(javax.servlet.http.Cookie cookie : cookies){
%>
                <li><%= cookie.getName() %> = <%= cookie.getValue() %></li>
<%
            }
        } else {
            out.println("No cookies found.");
        }
%>
    </ul>
<%
    }
%>
</body>
</html>
