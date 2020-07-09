import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AdminLogin extends HttpServlet {
        public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
        {
            resp.setContentType("text/html");
            PrintWriter ptr=resp.getWriter();
            String name=req.getParameter("uname");
            String pass=req.getParameter("pass");
            if(name.equals("Admin")&&pass.equals("Admin@123"))
            {
                RequestDispatcher dp=req.getRequestDispatcher("/admindisplay.html");
                dp.forward(req,resp);
            }
            else
            {
                ptr.println("<h2>Invalid Username Or Password</h2>");
                ptr.println("<button onclick="+"\"history.back()\""+">Back</button>");
            }
        }
}