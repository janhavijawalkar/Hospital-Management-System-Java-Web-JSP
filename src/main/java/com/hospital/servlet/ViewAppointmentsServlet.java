package com.hospital.servlet;

import java.io.IOException;
import java.util.List;

import com.hospital.dao.AppointmentDAO;
import com.hospital.model.Appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewAppointments")
public class ViewAppointmentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        AppointmentDAO dao = new AppointmentDAO();

        List<Appointment> appointments = dao.getAllAppointments();

        request.setAttribute("appointments", appointments);

        request.getRequestDispatcher("viewAppointments.jsp")
               .forward(request, response);
    }
}