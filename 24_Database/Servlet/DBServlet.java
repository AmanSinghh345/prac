import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DBServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Adjust JDBC driver, URL, user and password as needed
        String jdbcURL = "jdbc:mysql://localhost:3306/test";
        String dbUser = "root";
        String dbPass = "";
        
        try {
            Class.forName("com.mysql.jdbc.Driver"); // or com.mysql.cj.jdbc.Driver for newer versions
            Connection con = DriverManager.getConnection(jdbcURL, dbUser, dbPass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT column_name FROM table1");

            while (rs.next()) {
                out.println(rs.getString("column_name") + "<br>");
            }
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
