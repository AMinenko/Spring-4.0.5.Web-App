package com.ewms.repository.appointment;

import com.ewms.model.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentDao extends JpaRepository<Appointment,Long> {

    Appointment findById(Long id);

}
