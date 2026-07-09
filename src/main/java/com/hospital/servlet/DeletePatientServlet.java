package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.PatientDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletePatient")
public class DeletePatientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int patientId = Integer.parseInt(request.getParameter("id"));

        PatientDAO dao = new PatientDAO();

        dao.deletePatient(patientId);

        response.sendRedirect("viewPatients?success=Patient Deleted Successfully");
    }
}