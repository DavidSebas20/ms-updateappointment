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

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id, 
            @RequestBody Appointment newAppointmentData) {
        Appointment updatedAppointment = appointmentService.updateAppointment(id, newAppointmentData);
        return ResponseEntity.ok(updatedAppointment);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Healthy");
    }
}
