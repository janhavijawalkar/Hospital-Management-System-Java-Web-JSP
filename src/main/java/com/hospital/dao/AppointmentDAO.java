package com.hospital.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.Patient;
import com.hospital.model.Doctor;
import java.util.ArrayList;
import java.util.List;

import com.hospital.model.Appointment;
import com.hospital.util.DBConnection;

public class AppointmentDAO {

    // Book Appointment
    public boolean bookAppointment(Appointment appointment) {

        String query = "INSERT INTO appointments(patient_id,doctor_id,appointment_date) VALUES(?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, appointment.getPatientId());
            pst.setInt(2, appointment.getDoctorId());
            pst.setDate(3, appointment.getAppointmentDate());

            int rows = pst.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // View Appointments
    public List<Appointment> getAllAppointments() {

        List<Appointment> list = new ArrayList<>();

        String query =
                "SELECT a.appointment_id,a.patient_id,a.doctor_id,a.appointment_date,"
              + "p.name AS patient_name,"
              + "d.name AS doctor_name "
              + "FROM appointments a "
              + "JOIN patients p ON a.patient_id=p.patient_id "
              + "JOIN doctors d ON a.doctor_id=d.doctor_id";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while(rs.next()){

                Appointment a=new Appointment();

                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setDoctorId(rs.getInt("doctor_id"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setPatientName(rs.getString("patient_name"));
                a.setDoctorName(rs.getString("doctor_name"));
                list.add(a);
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return list;
    }

    // Delete Appointment
    public boolean deleteAppointment(int id) {

        String query = "DELETE FROM appointments WHERE appointment_id=?";

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

    // Check Duplicate
    public boolean appointmentExists(int patientId, int doctorId, Date date) {

        String query = "SELECT * FROM appointments WHERE patient_id=? AND doctor_id=? AND appointment_date=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, patientId);
            pst.setInt(2, doctorId);
            pst.setDate(3, date);

            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
    public List<Appointment> searchAppointmentByDate(java.sql.Date date){

        List<Appointment> list = new java.util.ArrayList<>();

        String query =
            "SELECT a.appointment_id,a.appointment_date," +
            "p.name patient_name," +
            "d.name doctor_name " +
            "FROM appointments a " +
            "JOIN patients p ON a.patient_id=p.patient_id " +
            "JOIN doctors d ON a.doctor_id=d.doctor_id " +
            "WHERE appointment_date=?";

        try{

            Connection con=DBConnection.getConnection();

            PreparedStatement pst=con.prepareStatement(query);

            pst.setDate(1,date);

            ResultSet rs=pst.executeQuery();

            while(rs.next()){

                Appointment a=new Appointment();

                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setPatientName(rs.getString("patient_name"));
                a.setDoctorName(rs.getString("doctor_name"));

                list.add(a);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
    public List<Patient> getAllPatients() {

        List<Patient> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("SELECT * FROM patients ORDER BY name");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Patient p = new Patient();

                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));

                list.add(p);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public List<Doctor> getAllDoctors(){

        List<Doctor> list = new ArrayList<>();

        try{

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("SELECT * FROM doctors ORDER BY name");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Doctor d = new Doctor();

                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(rs.getString("specialization"));

                list.add(d);

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
public int getAppointmentCount(){

    int count=0;

    try{

        Connection con=DBConnection.getConnection();

        PreparedStatement ps=
        con.prepareStatement("SELECT COUNT(*) FROM appointments");

        ResultSet rs=ps.executeQuery();

        if(rs.next())
            count=rs.getInt(1);

    }catch(Exception e){
        e.printStackTrace();
    }

    return count;
}
public int getTodayAppointmentCount(){

    int count = 0;

    try{

        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
            "SELECT COUNT(*) FROM appointments WHERE appointment_date = CURDATE()"
        );

        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            count = rs.getInt(1);

        }

    }catch(Exception e){

        e.printStackTrace();

    }

    return count;

}
public List<Appointment> getTodayAppointments(){

    List<Appointment> list = new ArrayList<>();

    String query =
    "SELECT a.appointment_id,a.appointment_date," +
    "p.name patient_name," +
    "d.name doctor_name " +
    "FROM appointments a " +
    "JOIN patients p ON a.patient_id=p.patient_id " +
    "JOIN doctors d ON a.doctor_id=d.doctor_id " +
    "WHERE appointment_date=CURDATE()";

    try{

        Connection con=DBConnection.getConnection();

        PreparedStatement pst=con.prepareStatement(query);

        ResultSet rs=pst.executeQuery();

        while(rs.next()){

            Appointment a=new Appointment();

            a.setAppointmentId(rs.getInt("appointment_id"));
            a.setAppointmentDate(rs.getDate("appointment_date"));
            a.setPatientName(rs.getString("patient_name"));
            a.setDoctorName(rs.getString("doctor_name"));

            list.add(a);

        }

    }catch(Exception e){

        e.printStackTrace();

    }

    return list;

}
}