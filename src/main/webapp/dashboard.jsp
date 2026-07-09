
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Hospital Dashboard</title>

<link rel="stylesheet" href="css/main.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">

</head>

<body>

<div class="container">

<!-- ================= SIDEBAR ================= -->

<aside class="sidebar">

<div>

<div class="logo-section">

<div class="logo-circle">

<i class="fa-solid fa-hospital"></i>

</div>

<h2>HospitalMS</h2>

</div>

<ul class="menu">

<li class="active">

<a href="dashboard">

<i class="fa-solid fa-house"></i>

Dashboard

</a>

</li>

<li>

<a href="addPatient.jsp">

<i class="fa-solid fa-user-plus"></i>

Add Patient

</a>

</li>

<li>

<a href="viewPatients">

<i class="fa-solid fa-users"></i>

Patients

</a>

</li>

<li>

<a href="addDoctor.jsp">

<i class="fa-solid fa-user-doctor"></i>

Add Doctor

</a>

</li>

<li>

<a href="viewDoctors">

<i class="fa-solid fa-stethoscope"></i>

Doctors

</a>

</li>

<li>

<a href="bookAppointmentPage">

<i class="fa-solid fa-calendar-plus"></i>

Book Appointment

</a>

</li>

<li>

<a href="viewAppointments">

<i class="fa-solid fa-calendar-check"></i>

Appointments

</a>

</li>

</ul>

</div>

<div class="logout">

<a href="logout">

<i class="fa-solid fa-right-from-bracket"></i>

Logout

</a>

</div>

</aside>

<!-- ================= MAIN ================= -->

<main class="main-content">

<div class="hero-section">

<div>

<h1>👋 Welcome Back, Administrator</h1>

<p>

Manage your hospital efficiently with one smart dashboard.

</p>

</div>

<div class="hero-date">

<i class="fa-solid fa-calendar-days"></i>

<span id="currentDate"></span>

</div>

</div>

<!-- ================= STATS ================= -->

<div class="stats-grid">

<div class="stat-card">

<div class="icon purple">

<i class="fa-solid fa-users"></i>

</div>

<h2>

<%= request.getAttribute("patientCount") == null ? 0 : request.getAttribute("patientCount") %>

</h2>

<p>Total Patients</p>

</div>

<div class="stat-card">

<div class="icon blue">

<i class="fa-solid fa-user-doctor"></i>

</div>

<h2>

<%= request.getAttribute("doctorCount") == null ? 0 : request.getAttribute("doctorCount") %>

</h2>

<p>Total Doctors</p>

</div>

<div class="stat-card">

<div class="icon green">

<i class="fa-solid fa-calendar-check"></i>

</div>

<h2>

<%= request.getAttribute("appointmentCount") == null ? 0 : request.getAttribute("appointmentCount") %>

</h2>

<p>Total Appointments</p>

</div>

<div class="stat-card">

<div class="icon orange">

<i class="fa-solid fa-clock"></i>

</div>

<h2>

<%= request.getAttribute("todayCount") == null ? 0 : request.getAttribute("todayCount") %>

</h2>

<p>Today's Appointments</p>

</div>

</div>
<!-- ================= QUICK ACTIONS ================= -->

<div class="quick-section">

<h2>Quick Actions</h2>

<div class="quick-grid">

<a href="addPatient.jsp" class="quick-card">

<i class="fa-solid fa-user-plus"></i>

<h3>Add Patient</h3>

<p>Create a new patient record</p>

</a>

<a href="addDoctor.jsp" class="quick-card">

<i class="fa-solid fa-user-doctor"></i>

<h3>Add Doctor</h3>

<p>Register hospital doctor</p>

</a>

<a href="bookAppointmentPage" class="quick-card">

<i class="fa-solid fa-calendar-plus"></i>

<h3>Book Appointment</h3>

<p>Schedule appointments</p>

</a>

<a href="viewPatients" class="quick-card">

<i class="fa-solid fa-users"></i>

<h3>View Patients</h3>

<p>Manage patient records</p>

</a>

<a href="viewDoctors" class="quick-card">

<i class="fa-solid fa-stethoscope"></i>

<h3>View Doctors</h3>

<p>Manage doctor records</p>

</a>

<a href="viewAppointments" class="quick-card">

<i class="fa-solid fa-calendar-days"></i>

<h3>Appointments</h3>

<p>Manage all appointments</p>

</a>

</div>

</div>


<script src="js/main.js"></script>
<div class="footer">

Hospital Management System © 2026

</div>
</body>

</html>
