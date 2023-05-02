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

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String r = """
                   <!DOCTYPE html>
                   <html>
                        <head>
                            <title>Login</title>
                        </head>
                        <body>
                            <p>Login sucessful.</p>
                        </body>
                   </html>
                   """;
        String db = "jdbc:mariadb://localhost/jobHelper";
        String username = request.getParameter("username");
        String pass= request.getParameter("password");; 
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");   
            Connection conn = DriverManager.getConnection(db);
            Statement stmt = conn.createStatement();
            String query = """ 
                           select * from users;
                           """;
            ResultSet result = stmt.executeQuery(query);
            conn.close();
            
            while(result.next())
            {
                int id = result.getInt(1);
                String n = result.getString(2);
                String e = result.getString(3);
                String p = result.getString(5);
                response.getWriter().println(id + " " + n + " " + e + " " + p);
                
                if(username==n && pass==p)
                {
                    response.getWriter().println("Login successful!");
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
