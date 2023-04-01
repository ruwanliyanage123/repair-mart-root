package com.repair.mart.root.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class RepairMartUtils {
    private RepairMartUtils() {
    }

    public static ResponseEntity<String> getResponseEntity(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>("{\"message\":\"" + message + "\"}", httpStatus);
    }
}
