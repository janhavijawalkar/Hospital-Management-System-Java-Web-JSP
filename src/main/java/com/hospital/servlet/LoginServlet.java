package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("=================================");
        System.out.println("Username = " + username);
        System.out.println("Password = " + password);

        UserDAO userDAO = new UserDAO();

        boolean result = userDAO.login(username, password);

        System.out.println("Login Result = " + result);
        System.out.println("=================================");

        if(result) {
        	response.sendRedirect(request.getContextPath()+"/dashboard");
        } else {
        	response.setContentType("text/html");

        	response.getWriter().println("""
        	<html>
        	<head>
        	<link rel='stylesheet' href='css/main.css'>
        	</head>

        	<body style='background:#eef5ff;'>

        	<div class='form-container'>

        	<h1 style='color:red;'>❌ Login Failed</h1>

        	<h3>Invalid Username or Password</h3>

        	<br>

        	<a href='login.jsp'>
        	<button>Try Again</button>
        	</a>

        	</div>

        	</body>

        	</html>
        	""");
        }
    }
}