package com.ewms;

import com.ewms.customvalidators.PhenixGridRequestValidation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PhenixGridRequestValidation
public class PhenixRequest {
    private Long gridIdentifier;
    private String gridName;
    private Integer filterBy;
}

