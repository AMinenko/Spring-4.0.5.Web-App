package com.ewms.dto.appointment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AppointmentResponse {
    private String driver;
    private String email;
    private BigDecimal trFrontTemp;
    private Date apptStartTs;
    private Long pltQty;
    private Date apptCmplteTs;
    private Date apptCheckOutTs;
    private BigDecimal trailrMiddleTemp;
    private BigDecimal trailrRearTemp;
    private String apptRefNumber;
    private Long driverNumber;
    private String trailerLoc;
    private Long caseQty;
}
