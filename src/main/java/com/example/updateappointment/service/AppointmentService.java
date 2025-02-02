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

    public Appointment updateAppointment(Long id, Appointment newAppointmentData) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);

        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            appointment.setPatientId(newAppointmentData.getPatientId());
            appointment.setDoctorId(newAppointmentData.getDoctorId());
            appointment.setAppointmentDate(newAppointmentData.getAppointmentDate());
            appointment.setAppointmentTime(newAppointmentData.getAppointmentTime());
            appointment.setStatus(newAppointmentData.getStatus());
            return appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
    }
}