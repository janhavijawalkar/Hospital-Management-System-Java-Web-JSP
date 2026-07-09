package com.hospital.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.hospital.dao.PatientDAO;
import com.hospital.model.Patient;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/searchPatient")
public class SearchPatientServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        String keyword=request.getParameter("keyword");

        PatientDAO dao=new PatientDAO();

        List<Patient> patients=dao.searchPatient(keyword);

        PrintWriter out=response.getWriter();

        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='css/main.css'>");
        out.println("</head><body>");

        out.println("<h2 style='text-align:center'>Search Result</h2>");

        out.println("<table class='patient-table'>");

        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Age</th>");
        out.println("<th>Gender</th>");
        out.println("<th>Disease</th>");
        out.println("<th>Contact</th>");
        out.println("</tr>");

        for(Patient p:patients){

            out.println("<tr>");

            out.println("<td>"+p.getPatientId()+"</td>");
            out.println("<td>"+p.getName()+"</td>");
            out.println("<td>"+p.getAge()+"</td>");
            out.println("<td>"+p.getGender()+"</td>");
            out.println("<td>"+p.getDisease()+"</td>");
            out.println("<td>"+p.getContact()+"</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<center><a href='viewPatients'>Back</a></center>");

        out.println("</body></html>");
    }
}