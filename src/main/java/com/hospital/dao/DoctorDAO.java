package com.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.Doctor;
import com.hospital.util.DBConnection;

public class DoctorDAO {

    // Add Doctor
    public boolean addDoctor(Doctor doctor) {

        String query = "INSERT INTO doctors(name,specialization) VALUES(?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, doctor.getName());
            pst.setString(2, doctor.getSpecialization());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // View Doctors
    public List<Doctor> getAllDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        String query = "SELECT * FROM doctors";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));

                doctors.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctors;
    }

    // Get Doctor By ID
    public Doctor getDoctorById(int id) {

        Doctor doctor = null;

        String query = "SELECT * FROM doctors WHERE doctor_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctor;
    }

    // Update Doctor
    public boolean updateDoctor(Doctor doctor) {

        String query = "UPDATE doctors SET name=?, specialization=? WHERE doctor_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, doctor.getName());
            pst.setString(2, doctor.getSpecialization());
            pst.setInt(3, doctor.getDoctorId());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Delete Doctor
    public boolean deleteDoctor(int id) {

        String query = "DELETE FROM doctors WHERE doctor_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, id);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // Search Doctor
    public List<Doctor> searchDoctor(String keyword) {

        List<Doctor> doctors = new ArrayList<>();

        String query = "SELECT * FROM doctors WHERE name LIKE ? OR specialization LIKE ?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                Doctor doctor = new Doctor();

                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("name"));
                doctor.setSpecialization(rs.getString("specialization"));

                doctors.add(doctor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return doctors;
    }
    
public int getDoctorCount(){

    int count=0;

    try{

        Connection con=DBConnection.getConnection();

        PreparedStatement ps=
        con.prepareStatement("SELECT COUNT(*) FROM doctors");

        ResultSet rs=ps.executeQuery();

        if(rs.next())
            count=rs.getInt(1);

    }catch(Exception e){
        e.printStackTrace();
    }

    return count;

}
}