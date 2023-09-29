package com.enterprise.commons.ws;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorWrapper {
    private String element;
    private String error;
}
