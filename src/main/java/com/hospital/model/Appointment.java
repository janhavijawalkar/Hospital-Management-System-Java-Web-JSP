package com.hospital.model;

import java.sql.Date;

public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;

    public Appointment() {}

    public Appointment(int patientId,int doctorId,Date appointmentDate){

        this.patientId=patientId;
        this.doctorId=doctorId;
        this.appointmentDate=appointmentDate;

    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }
    private String patientName;
    private String doctorName;
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

}