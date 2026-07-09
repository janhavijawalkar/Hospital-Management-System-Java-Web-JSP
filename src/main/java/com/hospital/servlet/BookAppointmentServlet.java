package com.hospital.servlet;

import java.io.IOException;
import java.sql.Date;

import com.hospital.dao.AppointmentDAO;
import com.hospital.model.Appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/bookAppointment")
public class BookAppointmentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        Date appointmentDate = Date.valueOf(request.getParameter("appointmentDate"));

        Appointment appointment =
                new Appointment(patientId, doctorId, appointmentDate);

        AppointmentDAO dao = new AppointmentDAO();

        if (dao.appointmentExists(patientId, doctorId, appointmentDate)) {

            response.getWriter().println(
                    "<h2>Appointment Already Exists!</h2><br><a href='bookAppointment.jsp'>Back</a>");

            return;
        }

        if (dao.bookAppointment(appointment)) {

        	response.sendRedirect("viewAppointments?success=Appointment Booked Successfully");

        } else {

            response.getWriter().println(
                    "<h2>Booking Failed!</h2>");
        }
    }
}