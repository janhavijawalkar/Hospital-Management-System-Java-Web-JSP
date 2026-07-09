<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.hospital.model.Doctor"%>

<%
Doctor d=(Doctor)request.getAttribute("doctor");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Edit Doctor</title>

<link rel="stylesheet" href="css/main.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">

</head>

<body>

<div class="page-container">

<div class="form-container">

<h2>

<i class="fa-solid fa-user-doctor"></i>

Edit Doctor

</h2>

<form action="updateDoctor" method="post">

<input
type="hidden"
name="doctorId"
value="<%=d.getDoctorId()%>">

<div class="input-group">

<label>Doctor Name</label>

<input
type="text"
name="name"
value="<%=d.getName()%>"
required>

</div>

<div class="input-group">

<label>Specialization</label>

<input
type="text"
name="specialization"
value="<%=d.getSpecialization()%>"
required>

</div>

<button
type="submit"
class="btn-primary">

<i class="fa-solid fa-floppy-disk"></i>

Update Doctor

</button>

<a
href="viewDoctors"
class="btn-secondary">

Cancel

</a>

</form>

</div>

</div>
<div class="footer">

Hospital Management System © 2026

</div>
</body>

</html>
