package com.ewms.service.appointment;

import com.ewms.model.appointment.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment create (Appointment appointment);
    List<Appointment> findAll();
    Appointment findById(Long Id);
    Appointment findByPalletQtyAndDriverName(Long palletQty, String driverName);
    Appointment removeById(Long id);
    Appointment findByEmail(String email);
    Appointment findByPalletQty(Long palletQty);
}
