package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.ProjectDAO;

public class UpdateStatusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("projectId"));

        String status = request.getParameter("status");

        ProjectDAO dao = new ProjectDAO();

        boolean f = dao.updateStatus(id, status);

        if (f) {

            response.sendRedirect("viewProjects.jsp");

        } else {

            response.getWriter().println("Status Update Failed");
        }
    }
}
