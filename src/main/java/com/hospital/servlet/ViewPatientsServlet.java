package com.hospital.servlet;

import java.io.IOException;
import java.util.List;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewPatients")
public class ViewPatientsServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        PatientDAO dao = new PatientDAO();

        List<Patient> patients = dao.getAllPatients();

        request.setAttribute("patients", patients);

        request.getRequestDispatcher("viewPatients.jsp")
               .forward(request, response);
    }
}