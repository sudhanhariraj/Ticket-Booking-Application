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
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
@WebServlet("/RegDetails")
public class RegDetails extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
    {
        resp.setContentType("html/type");
        PrintWriter pr=resp.getWriter();
        try
        {
            Connection con=DB_Connect.getCon();
            Statement st=con.createStatement();
            pr.println("Your data is not in the database");
            String username='\''+req.getParameter("newname")+'\'';
            String password='\''+req.getParameter("newpassword")+'\'';
            String gender='\''+req.getParameter("gender")+'\'';
            String phone='\''+req.getParameter("Phone")+'\'';
            String state='\''+req.getParameter("state")+'\'';
            String city='\''+req.getParameter("city")+'\'';
            int i=st.executeUpdate("insert into formdet values ("+username+","+password+","+gender+","+phone+","+state+","+city+")");
            int i1=st.executeUpdate("insert into form values ("+username+","+password+")");
            if(i!=0&&i1!=0)
            {
                pr.println("Registered Successfully");
                RequestDispatcher dp=req.getRequestDispatcher("/login.html");
                dp.forward(req, resp);
            }
            else
            {
                pr.println("Register The form with The Correct Data");
                RequestDispatcher re=req.getRequestDispatcher("/register.html");
                re.forward(req, resp);
            }
            con.close();
            pr.close();
        }
        catch(Exception e)
        {
            pr.println(e);
        }
    }
}
