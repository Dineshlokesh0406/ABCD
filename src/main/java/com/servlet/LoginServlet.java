package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.UserDAO;
import com.model.User;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        UserDAO dao = new UserDAO();

        User u = dao.login(email, password);

        if (u != null && u.getRole().equals(role)) {

            HttpSession session = request.getSession();

            session.setAttribute("user", u);

            if (role.equals("manager")) {

                response.sendRedirect("managerDashboard.jsp");

            } else {

                response.sendRedirect("employeeDashboard.jsp");
            }

        } else {

            response.getWriter().println("Invalid Credentials");
        }
    }
}
