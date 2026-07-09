package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editPatient")
public class EditPatientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        PatientDAO dao = new PatientDAO();

        Patient patient = dao.getPatientById(id);

        request.setAttribute("patient", patient);

        request.getRequestDispatcher("editPatient.jsp")
               .forward(request, response);
    }
}