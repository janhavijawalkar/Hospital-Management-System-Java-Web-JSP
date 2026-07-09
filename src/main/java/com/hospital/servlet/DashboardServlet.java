package com.hospital.servlet;

import java.io.IOException;
import java.util.List;

import com.hospital.dao.AppointmentDAO;
import com.hospital.dao.DoctorDAO;
import com.hospital.dao.PatientDAO;
import com.hospital.model.Appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        request.setAttribute("patientCount",
                patientDAO.getPatientCount());

        request.setAttribute("doctorCount",
                doctorDAO.getDoctorCount());

        request.setAttribute("appointmentCount",
                appointmentDAO.getAppointmentCount());

        request.setAttribute("todayCount",
                appointmentDAO.getTodayAppointmentCount());

        List<Appointment> todayAppointments =
                appointmentDAO.getTodayAppointments();

        request.setAttribute("todayAppointments",
                todayAppointments);

        request.getRequestDispatcher("dashboard.jsp")
               .forward(request, response);
    }
}