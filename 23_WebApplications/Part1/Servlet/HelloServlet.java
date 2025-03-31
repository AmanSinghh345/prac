import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("name") == null) {
            response.sendRedirect("login");
            return;
        }
        String name = (String) session.getAttribute("name");
        long startTime = (Long) session.getAttribute("start_time");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTimeStr = sdf.format(new Date(startTime));
        
        response.setContentType("text/html");
        response.getWriter().println("<html><head><title>Hello " + name + "</title>"
                + "<style>.top-right { position: absolute; top: 10px; right: 10px; }</style></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<div class='top-right'>Start Time: " + startTimeStr + "</div>");
        response.getWriter().println("<h1>Hello " + name + "</h1>");
        response.getWriter().println("<form method='post' action='logout'><input type='submit' value='Logout'></form>");
        response.getWriter().println("</body></html>");
    }
}
