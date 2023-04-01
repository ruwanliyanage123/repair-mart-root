package com.repair.mart.root.service.api;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserServiceApi {
    /**
     * Sign up
     * @return response entity
     */
    ResponseEntity<String> signUp(Map<String, String> requestMap);
}
