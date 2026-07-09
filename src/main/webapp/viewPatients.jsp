<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hospital.model.Patient" %>

<%@ include file="components/header.jsp"%>

<%@ include file="components/sidebar.jsp"%>

<%
List<Patient> patients=(List<Patient>)request.getAttribute("patients");
%>

<main class="main-content">

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
<div class="page-header">

<h1>

<i class="fa-solid fa-users"></i>

Patient Management

</h1>

<p>

View, Edit and Delete Registered Patients

</p>

</div>

<div class="table-toolbar">

<div class="search-box">

<i class="fa-solid fa-magnifying-glass"></i>

<input
type="text"
id="searchInput"
placeholder="Search Patient">

</div>
<a href="addPatient.jsp" class="save-btn">

<i class="fa-solid fa-user-plus"></i>

Add Patient

</a>
<div class="table-info">

Total Patients :
<b><%=patients.size()%></b>

</div>
</div>

<div class="table-card">

<table id="patientTable">

<thead>

<tr>

<th>ID</th>

<th>Name</th>

<th>Age</th>

<th>Gender</th>

<th>Disease</th>

<th>Contact</th>

<th>Edit</th>

<th>Delete</th>

</tr>

</thead>

<tbody>

<%
if(patients==null || patients.isEmpty()){
%>

<tr>

<td colspan="7" style="text-align:center;padding:30px;">

<i class="fa-solid fa-circle-info"></i>

No Patients Found

</td>

</tr>

<%
}else{

for(Patient p:patients){

%>

<tr>

<td><%=p.getPatientId()%></td>

<td><%=p.getName()%></td>

<td><%=p.getAge()%></td>

<td><%=p.getGender()%></td>

<td><%=p.getDisease()%></td>

<td><%=p.getContact()%></td>

<td>

<a href="editPatient?id=<%=p.getPatientId()%>" class="edit-btn">
    <i class="fa-solid fa-pen"></i>
    Edit
</a>

</td>

<td>

<a
href="deletePatient?id=<%=p.getPatientId()%>"

onclick="return confirm('Delete this patient?')"

class="delete-btn">

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

</div>

</main>

<%@ include file="components/footer.jsp"%>
<div class="footer">

Hospital Management System © 2026

</div>