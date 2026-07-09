package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hospital.util.DBConnection;

public class DashboardDAO {

    public int getPatientCount() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement("SELECT COUNT(*) FROM patients");

            ResultSet rs = pst.executeQuery();

            if(rs.next())
                return rs.getInt(1);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getDoctorCount() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement("SELECT COUNT(*) FROM doctors");

            ResultSet rs = pst.executeQuery();

            if(rs.next())
                return rs.getInt(1);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getAppointmentCount() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement("SELECT COUNT(*) FROM appointments");

            ResultSet rs = pst.executeQuery();

            if(rs.next())
                return rs.getInt(1);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

}