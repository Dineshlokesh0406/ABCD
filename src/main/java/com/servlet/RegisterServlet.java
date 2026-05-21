package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.model.User;

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        User u = new User();

        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);
        u.setRole(role);

        UserDAO dao = new UserDAO();

        boolean f = dao.registerUser(u);

        if (f) {

            response.sendRedirect("login.jsp");

        } else {

            response.getWriter().println("Registration Failed");
        }
    }
}
