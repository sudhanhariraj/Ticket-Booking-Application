import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DB.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
@WebServlet("/BOOK1")
public class BOOK1 extends HttpServlet {
        public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException
        {
            resp.setContentType("text/html");
            PrintWriter ptr=resp.getWriter();
            String travel='\''+req.getParameter("category")+'\'';
            String name=req.getParameter("pass_name");
            if(!name.matches("^[a-zA-Z]*$"))
            {
                ptr.println("<h2>Invalid Name</h2>");
                ptr.println("<button onclick="+"\"history.back()\""+">Back</button>");
            }
            else
            {
                try
                {
                    name='\''+name+'\'';
                    Connection con=DB_Connect.getCon();
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("insert into bookdet values ("+name+","+travel+")");
                    ptr.println("<h2>Booked Successfully</h2>");
                    ptr.println("<button onclick="+"\"history.back()\""+">Back</button>");
                    con.close();
                    rs.close();
                }
                catch(Exception e)
                {
                    ptr.println(e);
                }
            }
            ptr.close(); 
        }
}
