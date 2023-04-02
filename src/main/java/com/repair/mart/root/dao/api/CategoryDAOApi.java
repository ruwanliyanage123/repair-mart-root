package com.repair.mart.root.dao.api;

import com.repair.mart.root.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoryDAOApi extends JpaRepository<Category, Integer> {

    List<Category> getAllCategory();

    @Transactional
    @Modifying
    Integer update(@Param("name") String status, @Param("id") Integer id);
}
