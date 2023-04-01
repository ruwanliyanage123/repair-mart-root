package com.repair.mart.root.service.impl;

import com.repair.mart.root.constants.RepairMartConstants;
import com.repair.mart.root.dao.api.UserDAOApi;
import com.repair.mart.root.pojo.User;
import com.repair.mart.root.service.api.UserServiceApi;
import com.repair.mart.root.util.RepairMartUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserServiceApi {
    @Autowired
    UserDAOApi userDAO;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside sign up {}", requestMap);
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userDAO.findByEmailId(requestMap.get("email"));
                if (!Objects.isNull(user))
                    return RepairMartUtils.getResponseEntity("User Already Exists", HttpStatus.BAD_REQUEST);
                userDAO.save(getUserFromMap(requestMap));
                return RepairMartUtils.getResponseEntity("Successfully registered", HttpStatus.OK);
            } else {
                return RepairMartUtils.getResponseEntity(RepairMartConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN + "sign up", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        boolean isValidName = requestMap.containsKey("name");
        boolean isValidNumber = requestMap.containsKey("contactNumber");
        boolean isValidEmail = requestMap.containsKey("email");
        boolean isValidPassword = requestMap.containsKey("password");
        return isValidName && isValidNumber && isValidEmail && isValidPassword;
    }

    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus(requestMap.get("status"));
        user.setRole(requestMap.get("role"));
        return user;
    }
}
