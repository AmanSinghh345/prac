import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String name = "";
        long startTime = 0;
        if(session != null) {
            name = (String) session.getAttribute("name");
            startTime = (Long) session.getAttribute("start_time");
            session.invalidate();
        }
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime) / 1000; // seconds
        
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Logout</title></head><body>");
        response.getWriter().println("<h1>Thank You " + name + "</h1>");
        response.getWriter().println("<p>Duration of usage: " + duration + " seconds.</p>");
        response.getWriter().println("</body></html>");
    }
}
