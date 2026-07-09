package com.hospital.servlet;

import java.io.IOException;

import com.hospital.dao.AppointmentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/deleteAppointment")
public class DeleteAppointmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        AppointmentDAO dao = new AppointmentDAO();

        dao.deleteAppointment(id);

        response.sendRedirect("viewAppointments?success=Appointment Deleted Successfully");
    }
}