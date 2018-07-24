package com.ewms.dto.appointment;

import com.ewms.PhenixRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/*
* Do we really need create appointment header request?
* If Header DTO represents by itself a complete logicatl data structure with complete set of fields
* and this set is similar for request and response result why we don't use the it in the following way:
* AppointmentHeaderDto AppointmentDetailsDto - main DTOs which represents whole page structure
* and which are used for creation(like request) and for representation (like response)
 * (At the backed they undergo under mapper transformation)
*
* Other DTOs are queries queries which are used for searhich or creation specific parts
* and they can go directly to DAO layer without any remapping. However their result
* if it is a complete logical structure (like Appointment or AppointmentDetail) should undergo transhormation via mapper?
* */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AppointmentHeaderDto extends PhenixRequest {

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
