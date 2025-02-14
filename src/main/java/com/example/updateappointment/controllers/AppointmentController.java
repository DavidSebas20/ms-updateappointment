package com.example.updateappointment.controllers;

import com.example.updateappointment.entity.Appointment;
import com.example.updateappointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/update-appointment/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Actualizar el estado de una cita por ID
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointmentStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        Appointment updatedAppointment = appointmentService.updateAppointmentStatus(id, status);
        return ResponseEntity.ok(updatedAppointment);
    }

    // Health check
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Healthy");
    }
}