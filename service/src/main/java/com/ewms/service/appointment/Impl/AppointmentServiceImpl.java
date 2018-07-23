package com.ewms.service.appointment.Impl;

import com.ewms.model.appointment.Appointment;
import com.ewms.repository.appointment.AppointmentDao;
import com.ewms.repository.appointment.AppointmentQueryDao;
import com.ewms.service.appointment.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    @Override
    public Appointment create(Appointment appointment) {
     return    appointmentDao.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentDao.findAll();
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentDao.findById(id);
    }
}
