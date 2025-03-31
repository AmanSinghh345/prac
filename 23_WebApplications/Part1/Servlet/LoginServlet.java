import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display login form
        response.setContentType("text/html");
        response.getWriter().println(
            "<html><body><form method='post' action='login'>" +
            "Enter your name: <input type='text' name='name' required>" +
            "<input type='submit' value='Submit'>" +
            "</form></body></html>"
        );
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("start_time", System.currentTimeMillis());
        response.sendRedirect("hello");
    }
}
