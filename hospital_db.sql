-- ===========================================
-- Hospital Management System Database
-- Author : Janhavi Jawalkar
-- Database : hospital_db
-- ===========================================

CREATE DATABASE IF NOT EXISTS hospital_db;
USE hospital_db;

-- ===========================================
-- USERS TABLE
-- ===========================================

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password)
VALUES
('admin','admin123');

-- ===========================================
-- PATIENTS TABLE
-- ===========================================

DROP TABLE IF EXISTS patients;

CREATE TABLE patients (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    disease VARCHAR(100),
    contact VARCHAR(15)
);

INSERT INTO patients
(name, age, gender, disease, contact)
VALUES
('Rahul Sharma',25,'Male','Fever','9876543211'),
('Priya Patil',21,'Female','Cold','9865471254'),
('Amit Verma',40,'Male','Diabetes','9876512345'),
('Sneha Joshi',30,'Female','Migraine','9876509876'),
('Karan Singh',28,'Male','Fracture','9876540001');

-- ===========================================
-- DOCTORS TABLE
-- ===========================================

DROP TABLE IF EXISTS doctors;

CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    specialization VARCHAR(100) NOT NULL
);

INSERT INTO doctors
(name, specialization)
VALUES
('Dr. Sharma','Cardiologist'),
('Dr. Verma','Orthopedic'),
('Dr. Mehta','Dermatologist'),
('Dr. Kulkarni','General Physician'),
('Dr. Gupta','Neurologist');

-- ===========================================
-- APPOINTMENTS TABLE
-- ===========================================

DROP TABLE IF EXISTS appointments;

CREATE TABLE appointments (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,

    CONSTRAINT fk_patient
        FOREIGN KEY(patient_id)
        REFERENCES patients(patient_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_doctor
        FOREIGN KEY(doctor_id)
        REFERENCES doctors(doctor_id)
        ON DELETE CASCADE
);

INSERT INTO appointments
(patient_id, doctor_id, appointment_date)
VALUES
(1,1,'2026-07-10'),
(2,3,'2026-07-11'),
(3,2,'2026-07-12'),
(4,4,'2026-07-13'),
(5,5,'2026-07-14');

-- ===========================================
-- DEFAULT LOGIN
-- ===========================================

-- Username : admin
-- Password : admin123

-- ===========================================
-- END OF DATABASE
-- ===========================================
