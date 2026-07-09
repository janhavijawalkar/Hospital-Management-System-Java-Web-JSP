package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hospital.util.DBConnection;

public class UserDAO {

    public boolean login(String username, String password) {

        try {

            Connection con = DBConnection.getConnection();

            if (con == null) {
                System.out.println("❌ Database Connection Failed!");
                return false;
            }

            System.out.println("✅ Database Connected Successfully!");

            // Check which database is connected
            PreparedStatement dbStmt = con.prepareStatement("SELECT DATABASE()");
            ResultSet dbRs = dbStmt.executeQuery();

            if (dbRs.next()) {
                System.out.println("Connected Database: " + dbRs.getString(1));
            }

            System.out.println("--------------------------------");
            System.out.println("Username Entered : " + username);
            System.out.println("Password Entered : " + password);
            System.out.println("--------------------------------");

            // Display all users in the database
            PreparedStatement allUsers = con.prepareStatement("SELECT * FROM users");
            ResultSet allRs = allUsers.executeQuery();

            System.out.println("Users in Database:");

            while (allRs.next()) {
                System.out.println(
                        "Username = " + allRs.getString("username") +
                        " | Password = " + allRs.getString("password"));
            }

            // Actual login query
            String query = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, username.trim());
            pst.setString(2, password.trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("✅ Login Successful");
                return true;

            } else {

                System.out.println("❌ Login Failed");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}