package com.repair.mart.root.rest.impl;

import com.repair.mart.root.constants.RepairMartConstants;
import com.repair.mart.root.rest.api.UserRestApi;
import com.repair.mart.root.service.api.UserServiceApi;
import com.repair.mart.root.util.RepairMartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestImpl implements UserRestApi {
    @Autowired
    private UserServiceApi userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN + "signup", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN + "signup", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
