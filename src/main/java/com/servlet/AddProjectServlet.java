package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dao.ProjectDAO;
import com.model.Project;

public class AddProjectServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String projectName = request.getParameter("projectName");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        Project p = new Project();

        p.setProjectName(projectName);
        p.setDescription(description);
        p.setStatus(status);

        ProjectDAO dao = new ProjectDAO();

        boolean f = dao.addProject(p);

        if (f) {

            response.sendRedirect("viewProjects.jsp");

        } else {

            response.getWriter().println("Project Not Added");
        }
    }
}
