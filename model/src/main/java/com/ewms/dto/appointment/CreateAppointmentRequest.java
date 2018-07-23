package com.ewms.dto.appointment;

import com.ewms.PhenixRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CreateAppointmentRequest extends PhenixRequest {

    @NotNull
    @Size(max=4)
    private String driver;
    @Email
    private String email;
    @DecimalMax("12")
    private BigDecimal trFrontTemp;
    @Past
    private Date apptStartTs;
    @Positive
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
