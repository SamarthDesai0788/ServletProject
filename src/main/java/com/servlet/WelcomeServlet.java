package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        response.setContentType("text/html");

        out.println("<html><head><title>Welcome</title></head><body>");

        if (session != null) {
            String userid = (String) session.getAttribute("userid");
            out.println("Welcome to Profile servlet " + userid);
            out.println("<a href='index.html'>Index</a>"); // Show link when logged in
        } else {
            response.sendRedirect("login.html");
        }

        out.println("</body></html>"); // Close HTML tags
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}
