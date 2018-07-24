package com.ewms.model.appointment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String driverName;
    @Column
    private String emailAddress;
    @Column
    private BigDecimal frontTemp;
    @Column
    private Date apptStart;
    @Column
    private Long palletQty;

    //Direct maping
    @Column
    private Date apptCmplteTs;
    @Column
    private Date apptCheckOutTs;
    @Column
    private BigDecimal trailrMiddleTemp;
    @Column
    private BigDecimal trailrRearTemp;
    @Column
    private String apptRefNumber;
    @Column
    private Long driverNumber;
    @Column
    private String trailerLoc;
    @Column
    private Long caseQty;
}
