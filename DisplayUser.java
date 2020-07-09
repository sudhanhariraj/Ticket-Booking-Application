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
import javax.servlet.annotation.WebServlet;
@WebServlet("/DisplayUser")
public class DisplayUser extends HttpServlet {

     public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException
    {
        resp.setContentType("text/html");
        PrintWriter ptr=resp.getWriter();
        try
        {
            Connection con=DB_Connect.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from form");
            ptr.println("<html>");
            ptr.println("<head>");
            ptr.println("<style>"
                    + "table,th,td{"
                    + "color:white;"
                    + "background-color:blue;"
                    + "border-style:solid;"
                    + "border-color:black"
                    + "border-width:3px"
                    + "border-collapse-collapse;}");
            ptr.println("tr"
                    + "{bachground-color:red;"
                    + "}");
            ptr.println("</style>");
            ptr.println("</head>");
            ptr.println("<body>");
            if(rs.next())
            {
                rs=st.executeQuery("select * from formdet");
                ptr.println("<table><tr><th>Name</th><th>Gender</th><th>Phone Number</th><th>State</th><th>City</th></tr>");
                while(rs.next())
                {
                    ptr.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(3)+"</td>"+"<td>"
                                    + rs.getString(4)+"</td><td>"
                                            + rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
                }
                ptr.println("</table></body>");
                ptr.println("</html>");
            }
            else
            {
                ptr.println("No data");
            }
            rs.close();
            con.close();
        }
        catch(Exception e)
        {
            ptr.println(e);
        }
        ptr.close();
    }

}
