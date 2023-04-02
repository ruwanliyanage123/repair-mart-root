package com.repair.mart.root.rest.impl;

import com.repair.mart.root.constants.RepairMartConstants;
import com.repair.mart.root.rest.api.ProductRestApi;
import com.repair.mart.root.service.api.ProductServiceApi;
import com.repair.mart.root.util.RepairMartUtils;
import com.repair.mart.root.wrapper.ProductWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductRestImpl implements ProductRestApi {
    @Autowired
    ProductServiceApi productService;

    @Override
    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
        try {
            productService.addNewProduct(requestMap);
            return RepairMartUtils.getResponseEntity("Added category", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<ProductWrapper>> addNewProduct() {
        try {
            return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
