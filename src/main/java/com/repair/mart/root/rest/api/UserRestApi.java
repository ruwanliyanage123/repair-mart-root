package com.repair.mart.root.rest.api;

import com.repair.mart.root.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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

    /**
     * Login
     *
     * @param requestMap requested map
     * @return response
     */
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap);

    /**
     * Get All users
     * @return all users
     */
    @GetMapping(path = "/get")
    ResponseEntity<List<UserWrapper>> getAllUsers();

}
