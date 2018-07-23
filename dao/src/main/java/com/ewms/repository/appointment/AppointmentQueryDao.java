package com.ewms.repository.appointment;

import com.ewms.model.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

/*
*
* Not sure if wee need separate repo for query triggering?
* */
public interface AppointmentQueryDao extends JpaRepository<Appointment,Long>{

}
