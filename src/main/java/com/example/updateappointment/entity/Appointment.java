package com.example.updateappointment.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerado
    private Long id;

    @Column(name = "patient_id", nullable = false) // ID del paciente
    private Long patientId;

    @Column(name = "doctor_id", nullable = false) // ID del doctor
    private Long doctorId;

    @Column(name = "appointment_date", nullable = false) // Fecha de la cita
    private LocalDate appointmentDate;

    @Column(name = "appointment_time", nullable = false) // Hora de la cita
    private LocalTime appointmentTime;

    @Column(nullable = false) // Estado de la cita
    private String status;

    public Appointment() {}

    public Appointment(Long patientId, Long doctorId, LocalDate appointmentDate, LocalTime appointmentTime, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }

    public LocalTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}