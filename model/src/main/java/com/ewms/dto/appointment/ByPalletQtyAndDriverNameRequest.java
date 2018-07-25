package com.ewms.dto.appointment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ByPalletQtyAndDriverNameRequest {
    private Long palletQty;
    private String driverName;
}

