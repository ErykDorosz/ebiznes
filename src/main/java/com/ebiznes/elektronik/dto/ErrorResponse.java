package com.ebiznes.elektronik.dto;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ErrorResponse {
    @NotNull
    private final int code;
    @NotNull
    private final String message;
}
