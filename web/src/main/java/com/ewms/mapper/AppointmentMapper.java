package com.ewms.mapper;

import com.ewms.dto.appointment.AppointmentHeaderDto;
import com.ewms.model.appointment.Appointment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AppointmentMapper {

    AppointmentMapper MAPPER = Mappers.getMapper( AppointmentMapper.class );

    @Mappings({@Mapping(source = "driver", target = "driverName"),
            @Mapping(source = "email", target = "emailAddress"),
            @Mapping(source = "apptStartTs", target = "apptStart"),
            @Mapping(source = "pltQty", target = "palletQty"),
            @Mapping(source = "trFrontTemp", target = "frontTemp")})
    Appointment toAppointment(AppointmentHeaderDto appointmentRequest);

    @InheritInverseConfiguration
    AppointmentHeaderDto toAppointmentResponse(Appointment appointment);

    List<AppointmentHeaderDto> toAppointmentResponseList(List<Appointment> appointment);
}
