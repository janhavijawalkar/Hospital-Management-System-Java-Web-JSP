package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.DoctorDAO;
import com.hospital.model.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editDoctor")
public class EditDoctorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        DoctorDAO dao = new DoctorDAO();

        Doctor doctor = dao.getDoctorById(id);

        request.setAttribute("doctor", doctor);

        request.getRequestDispatcher("editDoctor.jsp")
               .forward(request, response);
    }
}