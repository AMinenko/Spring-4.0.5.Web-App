package com.ewms.controller;

import com.ewms.dto.appointment.AppointmentHeaderDto;
import com.ewms.dto.appointment.ByPalletQtyAndDriverNameRequest;
import com.ewms.model.appointment.Appointment;
import com.ewms.service.appointment.AppointmentService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

import static com.ewms.mapper.AppointmentMapper.MAPPER;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Inject
    private AppointmentService appointmentService;

    @GetMapping
    public List<AppointmentHeaderDto> getAll(){
        return MAPPER.toAppointmentResponseList(appointmentService.findAll());
    }

    @GetMapping("/{id}")
    public AppointmentHeaderDto findById(@PathVariable("id") @Valid @Positive Long id){
        return MAPPER.toAppointmentResponse(appointmentService.findById(id));
    }

    @PostMapping(consumes = "application/json")
    public AppointmentHeaderDto create(@Valid @RequestBody AppointmentHeaderDto createAppointmentRequest){
        Appointment appointment = MAPPER.toAppointment(createAppointmentRequest);

        Appointment result = appointmentService.create(appointment);
        return MAPPER.toAppointmentResponse(result);
    }

    @GetMapping("/getByEmail")
    public AppointmentHeaderDto getByEmail(@RequestParam("email") String email){
        Appointment result = appointmentService.findByEmail(email);
        return MAPPER.toAppointmentResponse(result);
    }

    @GetMapping("/getByPalletQty")
    public AppointmentHeaderDto getByPalletQty(@RequestParam("palletQty") Long palletQty){
        Appointment result = appointmentService.findByPalletQty(palletQty);
        return MAPPER.toAppointmentResponse(result);
    }

    @RequestMapping(value = "/by-pallet", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AppointmentHeaderDto findByPalletQtyAndDriverName(@RequestBody ByPalletQtyAndDriverNameRequest qry){
        return MAPPER.toAppointmentResponse(appointmentService.findByPalletQtyAndDriverName(qry.getPalletQty(),qry.getDriverName()));
    }

    @DeleteMapping("/{id}")
    public AppointmentHeaderDto removeById(@PathVariable("id") Long id){
        Appointment result = appointmentService.removeById(id);
        return MAPPER.toAppointmentResponse(result);
    }

}
