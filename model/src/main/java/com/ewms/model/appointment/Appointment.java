package com.ewms.model.appointment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "APPT_HEADER")
public class Appointment {
    @Id
    private long id;
    private String driverName;
    private String emailAddress;
    private BigDecimal frontTemp;
    private Date apptStart;
    private Long palletQty;

    //Direct maping
    private Date apptCmplteTs;
    private Date apptCheckOutTs;
    private BigDecimal trailrMiddleTemp;
    private BigDecimal trailrRearTemp;
    private String apptRefNumber;
    private Long driverNumber;
    private String trailerLoc;
    private Long caseQty;
}
