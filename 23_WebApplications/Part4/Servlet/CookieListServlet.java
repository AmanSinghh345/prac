import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set sample cookies if not already set
        if(request.getCookies() == null) {
            Cookie userCookie = new Cookie("user", "JohnDoe");
            userCookie.setMaxAge(3600);
            Cookie sessionCookie = new Cookie("sessionID", "XYZ123");
            sessionCookie.setMaxAge(3600);
            response.addCookie(userCookie);
            response.addCookie(sessionCookie);
        }
        response.setContentType("text/html");
        response.getWriter().println("<html><body>"
            + "<form method='post' action='cookieList'>"
            + "<input type='submit' value='List Cookies'>"
            + "</form></body></html>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        response.getWriter().println("<html><body><h3>Cookies Stored:</h3>");
        if(cookies != null && cookies.length > 0) {
            response.getWriter().println("<ul>");
            for(Cookie cookie : cookies) {
                response.getWriter().println("<li>" + cookie.getName() + " = " + cookie.getValue() + "</li>");
            }
            response.getWriter().println("</ul>");
        } else {
            response.getWriter().println("No cookies found.");
        }
        response.getWriter().println("</body></html>");
    }
}
