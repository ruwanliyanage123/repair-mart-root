package com.repair.mart.root.rest.impl;

import com.repair.mart.root.constants.RepairMartConstants;
import com.repair.mart.root.pojo.Category;
import com.repair.mart.root.rest.api.CategoryRestApi;
import com.repair.mart.root.service.api.CategoryServiceApi;
import com.repair.mart.root.util.RepairMartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CategoryRestImpl implements CategoryRestApi {
    @Autowired
    CategoryServiceApi categoryService;

    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
        try {
            return categoryService.addNewCategory(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategory(String filterValue) {
        try{
            return categoryService.getAllCategory(filterValue);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try{
            categoryService.update(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN + "signup", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
