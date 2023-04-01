package com.repair.mart.root.dao.api;

import com.repair.mart.root.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserDAOApi extends JpaRepository<User, Integer> {
    User findByEmailId(@Param("email") String email);//note: @Param("email") and email should be same
}
