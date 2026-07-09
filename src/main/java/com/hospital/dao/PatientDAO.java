package com.hospital.dao;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.hospital.model.Patient;
import com.hospital.util.DBConnection;

public class PatientDAO {

	public boolean addPatient(Patient patient) {

	    String query = "INSERT INTO patients(name, age, gender, disease, contact) VALUES (?, ?, ?, ?, ?)";

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement pst = con.prepareStatement(query);

	        pst.setString(1, patient.getName());
	        pst.setInt(2, patient.getAge());
	        pst.setString(3, patient.getGender());
	        pst.setString(4, patient.getDisease());
	        pst.setString(5, patient.getContact());

	        int rows = pst.executeUpdate();

	        return rows > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
    
	public java.util.List<Patient> getAllPatients() {

	    java.util.List<Patient> patients = new java.util.ArrayList<>();

	    String query = "SELECT * FROM patients";

	    try {

	        Connection con = DBConnection.getConnection();

	        PreparedStatement pst = con.prepareStatement(query);

	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {

	            Patient patient = new Patient();

	            patient.setPatientId(rs.getInt("patient_id"));
	            patient.setName(rs.getString("name"));
	            patient.setAge(rs.getInt("age"));
	            patient.setGender(rs.getString("gender"));
	            patient.setDisease(rs.getString("disease"));
	            patient.setContact(rs.getString("contact"));

	            patients.add(patient);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return patients;
	
    }

public void searchPatientById(int id) {

    String query = "SELECT * FROM patients WHERE patient_id = ?";

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            System.out.println("\nPatient Found:");
            System.out.println("ID: " + rs.getInt("patient_id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Age: " + rs.getInt("age"));
            System.out.println("Gender: " + rs.getString("gender"));
            System.out.println("Disease: " + rs.getString("disease"));
            System.out.println("Contact: " + rs.getString("contact"));
        } else {
            System.out.println("Patient not found.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
public boolean updatePatient(Patient patient) {

    String query = "UPDATE patients SET name=?, age=?, gender=?, disease=?, contact=? WHERE patient_id=?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, patient.getName());
        pst.setInt(2, patient.getAge());
        pst.setString(3, patient.getGender());
        pst.setString(4, patient.getDisease());
        pst.setString(5, patient.getContact());
        pst.setInt(6, patient.getPatientId());

        return pst.executeUpdate() > 0;

    } catch(Exception e) {
        e.printStackTrace();
    }

    return false;
}

public boolean deletePatient(int patientId) {

    String query = "DELETE FROM patients WHERE patient_id=?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, patientId);

        return pst.executeUpdate() > 0;

    } catch(Exception e) {
        e.printStackTrace();
    }

    return false;

}
public boolean patientExists(int patientId) {

    String query = "SELECT * FROM patients WHERE patient_id = ?";

    try {
        Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, patientId);

        ResultSet rs = pst.executeQuery();

        return rs.next();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
public Patient getPatientById(int id) {

    Patient patient = null;

    String query = "SELECT * FROM patients WHERE patient_id=?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        if(rs.next()) {

            patient = new Patient();

            patient.setPatientId(rs.getInt("patient_id"));
            patient.setName(rs.getString("name"));
            patient.setAge(rs.getInt("age"));
            patient.setGender(rs.getString("gender"));
            patient.setDisease(rs.getString("disease"));
            patient.setContact(rs.getString("contact"));
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return patient;
}
public java.util.List<Patient> searchPatient(String keyword) {

    java.util.List<Patient> patients = new java.util.ArrayList<>();

    String query = "SELECT * FROM patients WHERE name LIKE ? OR patient_id LIKE ?";

    try {

        Connection con = DBConnection.getConnection();

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1,"%"+keyword+"%");
        pst.setString(2,"%"+keyword+"%");

        ResultSet rs=pst.executeQuery();

        while(rs.next()){

            Patient p=new Patient();

            p.setPatientId(rs.getInt("patient_id"));
            p.setName(rs.getString("name"));
            p.setAge(rs.getInt("age"));
            p.setGender(rs.getString("gender"));
            p.setDisease(rs.getString("disease"));
            p.setContact(rs.getString("contact"));

            patients.add(p);
        }

    }catch(Exception e){
        e.printStackTrace();
    }

    return patients;
}
public int getPatientCount(){

    int count=0;

    try{

        Connection con=DBConnection.getConnection();

        PreparedStatement ps=
        con.prepareStatement("SELECT COUNT(*) FROM patients");

        ResultSet rs=ps.executeQuery();

        if(rs.next())
            count=rs.getInt(1);

    }catch(Exception e){
        e.printStackTrace();
    }

    return count;

}
}