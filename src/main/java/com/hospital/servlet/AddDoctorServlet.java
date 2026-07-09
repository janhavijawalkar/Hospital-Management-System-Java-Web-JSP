package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.DoctorDAO;
import com.hospital.model.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addDoctor")
public class AddDoctorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String specialization = request.getParameter("specialization");

        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setSpecialization(specialization);

        DoctorDAO dao = new DoctorDAO();

        if (dao.addDoctor(doctor)) {

            // Redirect to Doctor List
        	response.sendRedirect("viewDoctors?success=Doctor Added Successfully");

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

                <h3>Doctor could not be added.</h3>

                <br>

                <a href='addDoctor.jsp'>
                    <button>Try Again</button>
                </a>

            </div>

            </body>
            </html>
            """);
        }
    }
}