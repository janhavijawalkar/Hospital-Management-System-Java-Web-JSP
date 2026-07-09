package com.hospital.servlet;

import java.io.IOException;
import java.util.List;

import com.hospital.dao.DoctorDAO;
import com.hospital.model.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewDoctors")
public class ViewDoctorsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        DoctorDAO dao = new DoctorDAO();

        List<Doctor> doctors = dao.getAllDoctors();

        request.setAttribute("doctors", doctors);

        request.getRequestDispatcher("viewDoctors.jsp")
               .forward(request, response);
    }
}