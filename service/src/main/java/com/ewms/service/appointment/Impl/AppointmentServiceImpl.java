package com.ewms.service.appointment.Impl;

import com.ewms.model.appointment.Appointment;
import com.ewms.repository.appointment.AppointmentDao;
import com.ewms.repository.appointment.AppointmentQueryDao;
import com.ewms.service.appointment.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    @Autowired
    private AppointmentQueryDao appointmentQueryDao;

    @Override
    public Appointment create(Appointment appointment) {
     return appointmentDao.saveAndFlush(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentDao.findById(id);
    }

    @Override
    public Appointment findByPalletQtyAndDriverName(Long palletQty, String driverName) {
        return appointmentDao.findByPalletQtyAndDriverName(palletQty, driverName);
    }

    @Override
    public Appointment removeById(Long id) {
        return appointmentDao.removeAppointmentById(id);
    }

    @Override
    public Appointment findByEmail(String email) {
        return appointmentQueryDao.findByEmail(email);
    }

    @Override
    public Appointment findByPalletQty(Long palletQty) {
        return appointmentQueryDao.findByPalletQty(palletQty);
    }
}
