package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.DoctorDAO;
import com.hospital.model.Doctor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateDoctor")
public class UpdateDoctorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Doctor doctor = new Doctor();

        doctor.setDoctorId(
                Integer.parseInt(request.getParameter("doctorId")));

        doctor.setName(request.getParameter("name"));

        doctor.setSpecialization(
                request.getParameter("specialization"));

        DoctorDAO dao = new DoctorDAO();

        dao.updateDoctor(doctor);

        response.sendRedirect("viewDoctors?success=Doctor Updated Successfully");
    }
}