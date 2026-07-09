package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addPatient")
public class AddPatientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Patient patient = new Patient();

        patient.setName(request.getParameter("name"));
        patient.setAge(Integer.parseInt(request.getParameter("age")));
        patient.setGender(request.getParameter("gender"));
        patient.setDisease(request.getParameter("disease"));
        patient.setContact(request.getParameter("contact"));

        PatientDAO dao = new PatientDAO();

        if (dao.addPatient(patient)) {

            // Redirect to Patient List
        	response.sendRedirect("viewPatients?success=Patient Added Successfully");

        } else {

            response.setContentType("text/html");

            response.getWriter().println("""
            <html>
            <head>
                <link rel='stylesheet' href='css/main.css'>
            </head>

            <body>

            <div class='form-container'>

                <h1 style='color:red;'>❌ Failed</h1>

                <h3>Patient could not be added.</h3>

                <br>

                <a href='addPatient.jsp'>
                    <button>Try Again</button>
                </a>

            </div>

            </body>
            </html>
            """);
        }
    }
}