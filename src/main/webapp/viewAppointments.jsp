<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.hospital.model.Appointment"%>

<%
List<Appointment> appointments =
(List<Appointment>)request.getAttribute("appointments");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Appointments</title>

<link rel="stylesheet" href="css/main.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">

</head>

<body>
<%
String success = request.getParameter("success");

if(success != null){
%>

<div class="success-alert">

<i class="fa-solid fa-circle-check"></i>

<%=success%>

</div>

<%
}
%>
<div class="table-page">

<div class="table-card">

<div class="table-header">

<div>

<h2>

<i class="fa-solid fa-calendar-check"></i>

Appointment Management

</h2>

<p>Manage all appointments</p>

</div>

<div class="header-actions">

<form action="searchAppointment" method="post">

<input type="date"
name="appointmentDate"
class="search-box">

<button class="search-btn">
<i class="fa-solid fa-magnifying-glass"></i>
</button>

</form>

<a href="bookAppointmentPage"
class="add-btn">

<i class="fa-solid fa-calendar-plus"></i>

Book Appointment

</a>
<div class="table-info">

Total Appointments :
<b><%= (appointments==null)?0:appointments.size() %></b>

</div>

</div>

</div>

<table>

<thead>

<tr>

<th>ID</th>

<th>Patient</th>

<th>Doctor</th>

<th>Date</th>

<th>Actions</th>

</tr>

</thead>

<tbody>

<%
if(appointments!=null){

for(Appointment a:appointments){
%>

<tr>

<td><%=a.getAppointmentId()%></td>

<td><%=a.getPatientName()%></td>

<td><%=a.getDoctorName()%></td>

<td><%=a.getAppointmentDate()%></td>

<td>

<a href="deleteAppointment?id=<%=a.getAppointmentId()%>"
class="delete-btn"

onclick="return confirm('Delete this appointment?')">

<i class="fa-solid fa-trash"></i>

</a>

</td>

</tr>

<%
}
}
%>

</tbody>

</table>

<div class="back-section">

<a href="dashboard"
class="back-btn">

<i class="fa-solid fa-arrow-left"></i>

Dashboard

</a>

</div>

</div>

</div>

<div class="footer">

Hospital Management System © 2026

</div>
</body>

</html>