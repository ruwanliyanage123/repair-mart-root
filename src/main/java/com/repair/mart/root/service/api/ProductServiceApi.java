package com.repair.mart.root.service.api;

import com.repair.mart.root.wrapper.ProductWrapper;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ProductServiceApi {
    ResponseEntity<String> addNewProduct(Map<String, String> requestMap);

    List<ProductWrapper> getAllProducts();
}
