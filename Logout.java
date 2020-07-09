/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Logout")
public class Logout extends HttpServlet {
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException
    {
        resp.setContentType("text/html");
        PrintWriter ptr=resp.getWriter();
        RequestDispatcher disp=req.getRequestDispatcher("/Front.html");
        disp.forward(req,resp);
        ptr.close();
    }
}