package com.repair.mart.root.dao.api;

import com.repair.mart.root.pojo.Product;
import com.repair.mart.root.wrapper.ProductWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface ProductDaoApi extends JpaRepository<Product, Integer> {
    List<ProductWrapper> getAllProducts();
}
