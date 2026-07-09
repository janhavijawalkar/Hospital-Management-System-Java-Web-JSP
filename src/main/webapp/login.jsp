<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>HospitalMS Login</title>

<link rel="stylesheet" href="css/main.css">

<link rel="preconnect" href="https://fonts.googleapis.com">

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">

</head>

<body class="login-body">

<div class="login-card">

<div class="logo">

<i class="fa-solid fa-hospital"></i>

</div>

<h1>HospitalMS</h1>

<p>Hospital Management System</p>

<form action="login" method="post">

<div class="input-box">

<i class="fa-solid fa-user"></i>

<input type="text"
name="username"
placeholder="Username"
required>

</div>

<div class="input-box">

<i class="fa-solid fa-lock"></i>

<input type="password"
name="password"
placeholder="Password"
required>

</div>

<button class="login-btn">

<i class="fa-solid fa-arrow-right-to-bracket"></i>

Login

</button>

</form>

<span class="developer">

Designed & Developed by

<b>Janhavi Jawalkar</b>

</span>

</div>

</body>

</html>