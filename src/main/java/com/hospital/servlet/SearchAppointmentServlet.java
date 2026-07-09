package com.hospital.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.hospital.dao.AppointmentDAO;
import com.hospital.model.Appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/searchAppointment")
public class SearchAppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Date date =
        Date.valueOf(request.getParameter("appointmentDate"));

        AppointmentDAO dao=new AppointmentDAO();

        List<Appointment> appointments=
        dao.searchAppointmentByDate(date);

        request.setAttribute("appointments", appointments);

        request.getRequestDispatcher("viewAppointments.jsp")
               .forward(request,response);

    }
}