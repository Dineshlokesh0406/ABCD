package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.UserDAO;
import com.model.User;

public class EditProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User u = new User();

        u.setId(id);
        u.setName(name);
        u.setEmail(email);
        u.setPassword(password);

        UserDAO dao = new UserDAO();

        boolean f = dao.updateProfile(u);

        if (f) {

            response.sendRedirect("login.jsp");

        } else {

            response.getWriter().println("Profile Update Failed");
        }
    }
}
