package com.fan.wanwindow.repository;


import com.fan.wanwindow.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: ODM
 * @Date: 2023-12-27 21:13
 * @Description:
 * @Version: v1.0
 */


public interface UserRepository extends JpaRepository<UserInfo, String> {

    Optional<UserInfo> findByUserID(String userID);

}
