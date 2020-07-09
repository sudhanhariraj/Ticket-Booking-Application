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
import javax.servlet.http.Cookie;
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse resp)throws IOException
    {
        resp.setContentType("text/html");
        PrintWriter pr=resp.getWriter(); 
        try {
            Connection con=DB_Connect.getCon();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from form");
            String user=req.getParameter("username");
            String pass=req.getParameter("password");
            RequestDispatcher dp=req.getRequestDispatcher("/register.html");
            if(user.matches("^[a-zA-Z]*$"))
            {
                if(rs.next())
                {
                    rs=st.executeQuery("select Username,Password from form where Username="+'\''+user+'\'');
                    if(rs.next())
                    {
                        if(rs.getString(2).equals(pass)&&rs.getString(1).equals(user))
						{
                            RequestDispatcher dp1=req.getRequestDispatcher("/book.html");
                            dp1.forward(req,resp);
                        }
                        else
                        {
                            pr.println("<h2>Invalid Password</h2>");
                            pr.println("<button onclick="+"\"history.back()\""+">Back</button>");
                        }
                    }
                    else
                    {
                        dp.forward(req,resp);
                    }
                }
                else
                {
                    dp.forward(req,resp);
                }
            }
            else
            {
                pr.println("<h2>Invalid Username Or Password</h2>");
                pr.println("<button onclick="+"\"history.back()\""+">Back</button>");
            }
            con.close();
        } catch (Exception ex) {
            pr.println(ex);
        }
        pr.close();
    }
}
