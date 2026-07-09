package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatePatient")
public class UpdatePatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Patient patient = new Patient();

        patient.setPatientId(
                Integer.parseInt(request.getParameter("patientId")));

        patient.setName(request.getParameter("name"));

        patient.setAge(
                Integer.parseInt(request.getParameter("age")));

        patient.setGender(request.getParameter("gender"));

        patient.setDisease(request.getParameter("disease"));

        patient.setContact(request.getParameter("contact"));

        PatientDAO dao = new PatientDAO();

        dao.updatePatient(patient);

        response.sendRedirect("viewPatients?success=Patient Updated Successfully");
    }
}