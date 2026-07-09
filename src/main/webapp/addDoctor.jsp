<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ include file="components/header.jsp"%>
<%@ include file="components/sidebar.jsp"%>

<main class="main-content">

<div class="page-header">

<h1>
<i class="fa-solid fa-user-doctor"></i>
Add New Doctor
</h1>

<p>
Register a new doctor in the hospital
</p>

</div>

<div class="form-card">

<form action="addDoctor" method="post">

<div class="form-grid">

<div class="form-group">

<label>

<i class="fa-solid fa-user-doctor"></i>

Doctor Name

</label>

<input
type="text"
name="name"
required>

</div>

<div class="form-group">

<label>

<i class="fa-solid fa-stethoscope"></i>

Specialization

</label>

<select name="specialization" required>

<option value="">Select Specialization</option>

<option>General Physician</option>

<option>Cardiologist</option>

<option>Dermatologist</option>

<option>Neurologist</option>

<option>Orthopedic</option>

<option>Pediatrician</option>

<option>ENT Specialist</option>

<option>Gynecologist</option>

<option>Psychiatrist</option>

<option>Ophthalmologist</option>

</select>

</div>

</div>

<div class="form-buttons">

<button type="submit" class="save-btn">

<i class="fa-solid fa-floppy-disk"></i>

Save Doctor

</button>

<a href="dashboard" class="cancel-btn">

<i class="fa-solid fa-arrow-left"></i>

Back

</a>

</div>

</form>

</div>

</main>

<%@ include file="components/footer.jsp"%>
<div class="footer">

Hospital Management System © 2026

</div>