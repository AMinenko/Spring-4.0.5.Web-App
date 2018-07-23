package com.ewms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PhenixRequest {

    @NotNull
    private Long id;
}

