package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.AppointmentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookAppointmentPage")
public class BookAppointmentPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        AppointmentDAO dao = new AppointmentDAO();

        request.setAttribute("patients", dao.getAllPatients());

        request.setAttribute("doctors", dao.getAllDoctors());

        request.getRequestDispatcher("bookAppointment.jsp")
               .forward(request, response);

    }

}