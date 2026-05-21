package com.dao;

import java.sql.*;
import java.util.*;

import com.db.DBConnection;
import com.model.Project;

public class ProjectDAO {

    Connection conn = DBConnection.getConnection();

    // Add Project
    public boolean addProject(Project p) {

        boolean f = false;

        try {

            String sql = "insert into projects(project_name,description,status) values(?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getProjectName());
            ps.setString(2, p.getDescription());
            ps.setString(3, p.getStatus());

            int i = ps.executeUpdate();

            if (i == 1) {

                f = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return f;
    }

    // View Projects
    public List<Project> getAllProjects() {

        List<Project> list = new ArrayList<Project>();

        try {

            String sql = "select * from projects";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Project p = new Project();

                p.setProjectId(rs.getInt(1));
                p.setProjectName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setStatus(rs.getString(4));

                list.add(p);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    // Update Project
    public boolean updateProject(Project p) {

        boolean f = false;

        try {

            String sql = "update projects set project_name=?, description=?, status=? where project_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getProjectName());
            ps.setString(2, p.getDescription());
            ps.setString(3, p.getStatus());
            ps.setInt(4, p.getProjectId());

            int i = ps.executeUpdate();

            if (i == 1) {

                f = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return f;
    }

    // Delete Project
    public boolean deleteProject(int id) {

        boolean f = false;

        try {

            String sql = "delete from projects where project_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            int i = ps.executeUpdate();

            if (i == 1) {

                f = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return f;
    }

    // Update Status
    public boolean updateStatus(int id, String status) {

        boolean f = false;

        try {

            String sql = "update projects set status=? where project_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, id);

            int i = ps.executeUpdate();

            if (i == 1) {

                f = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return f;
    }
}