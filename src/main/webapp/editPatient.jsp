<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hospital.model.Patient" %>

<%
Patient p=(Patient)request.getAttribute("patient");
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Edit Patient</title>

<link rel="stylesheet" href="css/main.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">

</head>

<body>

<div class="page-container">

<div class="form-container">

<h2>

<i class="fa-solid fa-user-pen"></i>

Edit Patient

</h2>

<form action="updatePatient" method="post">

<input type="hidden" name="patientId"
value="<%=p.getPatientId()%>">

<div class="input-group">

<label>Name</label>

<input type="text"
name="name"
value="<%=p.getName()%>"
required>

</div>

<div class="input-group">

<label>Age</label>

<input type="number"
name="age"
value="<%=p.getAge()%>"
required>

</div>

<div class="input-group">

<label>Gender</label>

<select name="gender">

<option value="Male"
<%=p.getGender().equals("Male")?"selected":""%>>
Male
</option>

<option value="Female"
<%=p.getGender().equals("Female")?"selected":""%>>
Female
</option>

<option value="Other"
<%=p.getGender().equals("Other")?"selected":""%>>
Other
</option>

</select>

</div>

<div class="input-group">

<label>Disease</label>

<input type="text"
name="disease"
value="<%=p.getDisease()%>"
required>

</div>

<div class="input-group">

<label>Contact</label>

<input type="text"
name="contact"
value="<%=p.getContact()%>"
required>

</div>

<button type="submit" class="btn-primary">

<i class="fa-solid fa-floppy-disk"></i>

Update Patient

</button>

<a href="viewPatients" class="btn-secondary">

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
