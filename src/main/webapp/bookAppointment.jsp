<%@ page import="java.util.List"%>
<%@ page import="com.hospital.model.Patient"%>
<%@ page import="com.hospital.model.Doctor"%>

<%@ include file="components/header.jsp"%>
<%@ include file="components/sidebar.jsp"%>

<%
List<Patient> patients=(List<Patient>)request.getAttribute("patients");
List<Doctor> doctors=(List<Doctor>)request.getAttribute("doctors");
%>

<main class="main-content">

<div class="page-header">

<h1>

<i class="fa-solid fa-calendar-plus"></i>

Book Appointment

</h1>

<p>

Schedule a new patient appointment

</p>

</div>

<div class="form-card">

<form action="bookAppointment" method="post">

<div class="form-grid">

<div class="form-group">

<label>

<i class="fa-solid fa-user"></i>

Patient

</label>

<select name="patientId" required>

<option value="">Select Patient</option>

<%

if(patients!=null){

for(Patient p:patients){

%>

<option value="<%=p.getPatientId()%>">

<%=p.getName()%>

</option>

<%

}

}

%>

</select>

</div>

<div class="form-group">

<label>

<i class="fa-solid fa-user-doctor"></i>

Doctor

</label>

<select name="doctorId" required>

<option value="">Select Doctor</option>

<%

if(doctors!=null){

for(Doctor d:doctors){

%>

<option value="<%=d.getDoctorId()%>">

<%=d.getName()%> - <%=d.getSpecialization()%>

</option>

<%

}

}

%>

</select>

</div>

<div class="form-group">

<label>

<i class="fa-solid fa-calendar"></i>

Appointment Date

</label>

<input
type="date"
name="appointmentDate"
required>

</div>

</div>

<div class="form-buttons">

<button class="save-btn">

<i class="fa-solid fa-calendar-check"></i>

Book Appointment

</button>

<a href="dashboard" class="cancel-btn">

<i class="fa-solid fa-arrow-left"></i>

Dashboard

</a>

</div>

</form>

</div>

</main>

<%@ include file="components/footer.jsp"%>
<div class="footer">

Hospital Management System © 2026

</div>