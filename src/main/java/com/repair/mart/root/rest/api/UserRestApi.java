package com.repair.mart.root.rest.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/user")
public interface UserRestApi {

    /**
     * Sign up
     *
     * @param requestMap requested map
     * @return response
     */
    @PostMapping(path = "/signup")
    ResponseEntity<String> signUp(@RequestBody(required = true)Map<String, String> requestMap);

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap);

}
