package com.repair.mart.root.rest.api;

import com.repair.mart.root.pojo.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/category")
public interface CategoryRestApi {
    /**
     * To update user
     * @param requestMap
     * @return
     */
    @PostMapping(path = "/add")
    ResponseEntity<String> addNewCategory(@RequestBody(required = true) Map<String, String> requestMap);

    /**
     * To update user
     * @param requestMap
     * @return
     */
    @GetMapping(path = "/get")
    ResponseEntity<List<Category>> getAllCategory(@RequestParam(required = false) String filterValue);

    /**
     * To update user
     * @param requestMap
     * @return
     */
    @PostMapping("/update")
    ResponseEntity<String> update(@RequestBody(required = true) Map<String, String> requestMap);
}
