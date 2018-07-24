package com.ewms.repository.appointment;

import com.ewms.model.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment,Long> {

    Appointment findById(Long id);

    Appointment findByPalletQtyAndDriverName(Long palletQty, String driverName);

    Appointment removeAppointmentById(Long id);

    @Override
    Appointment saveAndFlush(Appointment appointment);

    @Override
    List<Appointment> findAll();
}
