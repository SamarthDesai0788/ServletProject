package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String userid=request.getParameter("userid");
       String password=request.getParameter("password");
       
 
       HttpSession session=request.getSession();
    if(password.equals("admin"))
    {
    	session.setAttribute("userid", userid);
    	response.sendRedirect("./WelcomeServlet");
    }
    else {
    	response.sendRedirect("login.html"); 
    }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doGet(request,response);
    }
  }
