import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String r = """
                   <!DOCTYPE html>
                   <html>
                        <head>
                            <title>Register</title>
                        </head>
                        <body>
                            <p>Registration sucessful.</p>
                        </body>
                   </html>
                   """;
        String db = "jdbc:mariadb://localhost/jobHelper";
        String username = request.getParameter("username");
        String email= request.getParameter("email");;
        String phone= request.getParameter("phone");;
        String pass= request.getParameter("password");; 
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");   
            Connection conn = DriverManager.getConnection(db);
            Statement stmt = conn.createStatement();
            String query = """ 
                           INSERT INTO users(username, email, phone, pass) 
                           VALUES (\"%s\", \"%s\", \"%s\", \"%s\");
                           """.formatted(username, email, phone, pass);
            ResultSet result = stmt.executeQuery(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.getWriter().println("Registration successful");
    }
}
