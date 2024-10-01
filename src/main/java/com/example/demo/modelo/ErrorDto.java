package com.example.demo.modelo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String code;
    private String message;
    private String field;
}
