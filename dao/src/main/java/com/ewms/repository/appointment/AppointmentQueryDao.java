package com.ewms.repository.appointment;

import com.ewms.model.appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*
*
* Not sure if wee need separate repo for query triggering?
* */
public interface AppointmentQueryDao extends JpaRepository<Appointment, Long>{

    @Query("select ap from Appointment ap where ap.emailAddress = :email")
    Appointment findByEmail(@Param("email") String email);

    @Query("select ap from Appointment ap where ap.palletQty = :palletQty")
    Appointment findByPalletQty(@Param("palletQty") Long palletQty);

}
