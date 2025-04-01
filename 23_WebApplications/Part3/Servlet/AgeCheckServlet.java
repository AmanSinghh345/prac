import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AgeCheckServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display form
        response.setContentType("text/html");
        response.getWriter().println("<html><body><form method='post' action='ageCheck'>" +
            "Name: <input type='text' name='name' required><br><br>" +
            "Age: <input type='number' name='age' required><br><br>" +
            "<input type='submit' value='Submit'>" +
            "</form></body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        response.setContentType("text/html");
        if(age < 18) {
            response.getWriter().println("<html><body>Hello " + name + ", you are not authorized to visit the site.</body></html>");
        } else {
            response.getWriter().println("<html><body>Welcome " + name + " to this site.</body></html>");
        }
    }
}
