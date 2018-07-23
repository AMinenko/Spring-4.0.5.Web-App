package com.ewms.controller;

import com.ewms.dto.appointment.AppointmentResponse;
import com.ewms.dto.appointment.CreateAppointmentRequest;
import com.ewms.model.appointment.Appointment;
import com.ewms.service.appointment.AppointmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

import static com.ewms.mapper.AppointmentMapper.MAPPER;

@RestController("/appointments")
public class AppointmentController {

    @Inject
    private AppointmentService appointmentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentResponse> getAll(){
        return MAPPER.toAppointmentResponseList(appointmentService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public AppointmentResponse create(@Valid @RequestBody CreateAppointmentRequest createAppointmentRequest){
        Appointment appointment = MAPPER.toAppointment(createAppointmentRequest);

        Appointment result = appointmentService.create(appointment);
        return MAPPER.toAppointmentResponse(result);
    }

  //  @RequestMapping("{id}")
    @ResponseBody
    public AppointmentResponse findById(@PathVariable Long id){
        return null;
        //return MAPPER.toAppointmentResponse(appointmentService.findById(id));
    }

}
