package com.repair.mart.root.service.impl;

import com.repair.mart.root.constants.RepairMartConstants;
import com.repair.mart.root.dao.api.ProductDaoApi;
import com.repair.mart.root.pojo.Category;
import com.repair.mart.root.pojo.Product;
import com.repair.mart.root.service.api.ProductServiceApi;
import com.repair.mart.root.util.RepairMartUtils;
import com.repair.mart.root.wrapper.ProductWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductServiceApi {
    @Autowired
    ProductDaoApi productDao;

    @Override
    public ResponseEntity<String> addNewProduct(Map<String, String> requestMap) {
        try {
            productDao.save(geProductFromMap(requestMap, false));
            return RepairMartUtils.getResponseEntity("Added product", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RepairMartUtils.getResponseEntity(RepairMartConstants.ERROR_OCCURRING_WHEN, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Product geProductFromMap(Map<String, String> requestMap, boolean isAdd) {
        Category category = new Category();
        category.setId(Integer.parseInt(requestMap.get("categoryId")));

        Product product = new Product();
        product.setStatus("true");
        product.setCategory(category);
        product.setName(requestMap.get("name"));
        product.setDescription(requestMap.get("description"));
        product.setPrice(Integer.parseInt(requestMap.get("price")));
        return product;
    }

    @Override
    public List<ProductWrapper> getAllProducts() {
        try {
            return productDao.getAllProducts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
