package com.repair.mart.root.service.api;

import com.repair.mart.root.pojo.User;
import com.repair.mart.root.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface UserServiceApi {
    /**
     * Sign up
     * @return response entity
     */
    ResponseEntity<String> signUp(Map<String, String> requestMap);


    /**
     * Login
     * @return response entity
     */
    ResponseEntity<String> login(Map<String, String> requestMap);

    /**
     * Login
     * @return response entity
     */
    ResponseEntity<List<UserWrapper>> getAllUser();

    /**
     * update
     * @return response entity
     */
    ResponseEntity<String> update(Map<String, String> requestMap);


}
