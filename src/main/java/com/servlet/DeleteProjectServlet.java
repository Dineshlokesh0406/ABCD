package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.ProjectDAO;

public class DeleteProjectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProjectDAO dao = new ProjectDAO();

        boolean f = dao.deleteProject(id);

        if (f) {

            response.sendRedirect("viewProjects.jsp");

        } else {

            response.getWriter().println("Delete Failed");
        }
    }
}
