<%@ page import="java.util.List"%>
<%@ page import="com.hospital.model.Doctor"%>

<%@ include file="components/header.jsp"%>
<%@ include file="components/sidebar.jsp"%>

<%
List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctors");
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
<i class="fa-solid fa-user-doctor"></i>
Doctor Management
</h1>

<p>View, Edit and Delete Registered Doctors</p>

</div>

<div class="table-toolbar">

<div class="search-box">

<i class="fa-solid fa-magnifying-glass"></i>

<input
type="text"
id="searchDoctor"
placeholder="Search Doctor">

</div>

<a href="addDoctor.jsp" class="save-btn">

<i class="fa-solid fa-user-plus"></i>

Add Doctor

</a>

<div class="table-info">

Total Doctors :
<b><%= (doctors == null) ? 0 : doctors.size() %></b>

</div>
</div>

<div class="table-card">

<table id="doctorTable">

<thead>

<tr>

<th>ID</th>
<th>Doctor Name</th>
<th>Specialization</th>
<th>Edit</th>
<th>Delete</th>

</tr>

</thead>

<tbody>

<%
if(doctors == null || doctors.isEmpty()){
%>

<tr>

<td colspan="5" style="text-align:center;padding:30px;">

<i class="fa-solid fa-circle-info"></i>

No Doctors Found

</td>

</tr>

<%
}else{

for(Doctor d : doctors){
%>

<tr>

<td><%=d.getDoctorId()%></td>

<td><%=d.getName()%></td>

<td><%=d.getSpecialization()%></td>

<td>

<a href="editDoctor?id=<%=d.getDoctorId()%>" class="edit-btn">

<i class="fa-solid fa-pen"></i>

Edit

</a>

</td>

<td>

<a href="deleteDoctor?id=<%=d.getDoctorId()%>"
class="delete-btn"
onclick="return confirm('Delete this doctor?')">

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