package com.repair.mart.root.dao.api;

import com.repair.mart.root.pojo.User;
import com.repair.mart.root.wrapper.UserWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDAOApi extends JpaRepository<User, Integer> {
    User findByEmailId(@Param("email") String email);//note: @Param("email") and email should be same

    List<UserWrapper> getAllUser();

    @Transactional
    @Modifying
    Integer updateStatus(@Param("status") String status, @Param("id") Integer id);
}
