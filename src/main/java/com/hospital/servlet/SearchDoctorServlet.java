package com.hospital.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.hospital.dao.DoctorDAO;
import com.hospital.model.Doctor;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/searchDoctor")
public class SearchDoctorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        String keyword=request.getParameter("keyword");

        DoctorDAO dao=new DoctorDAO();

        List<Doctor> doctors=dao.searchDoctor(keyword);

        PrintWriter out=response.getWriter();

        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head><body>");

        out.println("<div class='navbar'><h2>Search Doctors</h2></div>");

        out.println("<table class='patient-table'>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Specialization</th>");
        out.println("</tr>");

        for(Doctor d:doctors){

            out.println("<tr>");

            out.println("<td>"+d.getDoctorId()+"</td>");
            out.println("<td>"+d.getName()+"</td>");
            out.println("<td>"+d.getSpecialization()+"</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<center><br><a href='viewDoctors'>Back</a></center>");

        out.println("</body></html>");
    }
}