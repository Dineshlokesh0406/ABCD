package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.DBConnection;
import com.model.User;

public class UserDAO {

    Connection conn = DBConnection.getConnection();

    // Register User
    public boolean registerUser(User u) {

        boolean f = false;

        try {

            String sql = "insert into users(name,email,password,role) values(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRole());

            int i = ps.executeUpdate();

            if (i == 1) {

                f = true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return f;
    }

    // Login User
    public User login(String email, String password) {

        User u = null;

        try {

            String sql = "select * from users where email=? and password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                u = new User();

                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setRole(rs.getString("role"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return u;
    }

    // Update Profile
    public boolean updateProfile(User u) {

        boolean f = false;

        try {

            String sql = "update users set name=?, email=?, password=? where id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getId());

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