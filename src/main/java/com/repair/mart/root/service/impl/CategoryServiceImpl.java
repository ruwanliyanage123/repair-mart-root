package com.repair.mart.root.service.impl;

import com.repair.mart.root.constants.RepairMartConstants;
import com.repair.mart.root.dao.api.CategoryDAOApi;
import com.repair.mart.root.pojo.Category;
import com.repair.mart.root.pojo.User;
import com.repair.mart.root.service.api.CategoryServiceApi;
import com.repair.mart.root.util.RepairMartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryServiceApi {
    @Autowired
    CategoryDAOApi categoryDAO;

    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
        try {
            categoryDAO.save(getCategoryFromMap(requestMap));
            return RepairMartUtils.getResponseEntity("Added category", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategory(String filter) {
        try {
            return new ResponseEntity<>(categoryDAO.getAllCategory(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try {
            Optional<Category> optional = categoryDAO.findById(Integer.parseInt(requestMap.get("id")));
            categoryDAO.update(requestMap.get("name"), Integer.parseInt(requestMap.get("id")));
            return new ResponseEntity<>("updated user status", HttpStatus.OK);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN + "update", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Category getCategoryFromMap(Map<String, String> requestMap) {
        Category category = new Category();
        category.setName(requestMap.get("name"));
        return category;
    }
}
