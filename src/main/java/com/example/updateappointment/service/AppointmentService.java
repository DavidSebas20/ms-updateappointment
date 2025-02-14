package com.example.updateappointment.service;

import com.example.updateappointment.entity.Appointment;
import com.example.updateappointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Actualizar el estado de una cita
    public Appointment updateAppointmentStatus(Long id, String status) {
        // Validar que el estado sea "PENDING" o "CANCELLED"
        if (!"PENDING".equalsIgnoreCase(status) && !"CANCELLED".equalsIgnoreCase(status)) {
            throw new IllegalArgumentException("Invalid status. Must be 'PENDING' or 'CANCELLED'.");
        }

        // Buscar la cita por ID
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isEmpty()) {
            throw new RuntimeException("Appointment not found with ID: " + id);
        }

        // Actualizar el estado
        Appointment appointment = optionalAppointment.get();
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }
}