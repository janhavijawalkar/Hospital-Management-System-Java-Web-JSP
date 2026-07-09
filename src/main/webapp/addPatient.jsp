<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Add Patient</title>

<link rel="stylesheet" href="css/main.css">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">

</head>

<body>

<div class="container">

    <!-- Sidebar -->

    <aside class="sidebar">

        <div>

            <div class="logo-section">

                <div class="logo-circle">

                    <i class="fa-solid fa-hospital"></i>

                </div>

                <h2>HospitalMS</h2>

            </div>

            <ul class="menu">

                <li>
                    <a href="dashboard.jsp">
                        <i class="fa-solid fa-house"></i>
                        Dashboard
                    </a>
                </li>

                <li class="active">
                    <a href="addPatient.jsp">
                        <i class="fa-solid fa-user-plus"></i>
                        Add Patient
                    </a>
                </li>

                <li>
                    <a href="viewPatients">
                        <i class="fa-solid fa-users"></i>
                        View Patients
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
                        View Doctors
                    </a>
                </li>

                <li>
                    <a href="bookAppointmentPage">
                        <i class="fa-solid fa-calendar-plus"></i>
                        Appointment
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

    <!-- Main -->

    <main class="main-content">

        <div class="page-header">

            <h1>

                <i class="fa-solid fa-user-plus"></i>

                Add New Patient

            </h1>

            <p>Fill in patient information</p>

        </div>

        <div class="form-card">

            <form action="addPatient" method="post">

                <div class="form-grid">

                    <div class="form-group">

                        <label>

                            <i class="fa-solid fa-user"></i>

                            Full Name

                        </label>

                        <input
                        type="text"
                        name="name"
                        required>

                    </div>

                    <div class="form-group">

                        <label>

                            <i class="fa-solid fa-cake-candles"></i>

                            Age

                        </label>

                        <input
                        type="number"
                        name="age"
                        required>

                    </div>

                    <div class="form-group">

                        <label>

                            <i class="fa-solid fa-venus-mars"></i>

                            Gender

                        </label>

                        <select name="gender">

                            <option>Male</option>

                            <option>Female</option>

                            <option>Other</option>

                        </select>

                    </div>

                    <div class="form-group">

                        <label>

                            <i class="fa-solid fa-phone"></i>

                            Contact

                        </label>

                        <input
                        type="text"
                        name="contact"
                        required>

                    </div>

                </div>

                <div class="form-group full">

                    <label>

                        <i class="fa-solid fa-notes-medical"></i>

                        Disease

                    </label>

                    <textarea
                    name="disease"
                    rows="4"
                    required></textarea>

                </div>

                <div class="form-buttons">

                    <button type="submit" class="save-btn">

                        <i class="fa-solid fa-floppy-disk"></i>

                        Save Patient

                    </button>

                    <a href="dashboard" class="cancel-btn">

                        <i class="fa-solid fa-arrow-left"></i>

                        Dashboard

                    </a>

                </div>

            </form>

        </div>

    </main>

</div>
<div class="footer">

Hospital Management System © 2026

</div>
</body>

</html>
