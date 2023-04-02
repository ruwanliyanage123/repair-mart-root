package com.repair.mart.root.service.api;

import com.repair.mart.root.pojo.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CategoryServiceApi {
    ResponseEntity<String> addNewCategory(Map<String, String> requestMap);

    ResponseEntity<List<Category>> getAllCategory(String filter);

    ResponseEntity<String> update(Map<String, String> requestMap);
}
