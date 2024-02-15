package com.fan.wanwindow.service.impl;


import com.fan.wanwindow.entity.UserInfo;
import com.fan.wanwindow.repository.UserRepository;
import com.fan.wanwindow.service.UserService;
import com.fan.wanwindow.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: ODM
 * @Date: 2023-12-27 21:12
 * @Description:
 * @Version: v1.0
 */

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String login(String username, String password) {
        Optional<UserInfo> byUserID = userRepository.findByUserID(username);
        if (byUserID.isPresent()){
            UserInfo userInfo = byUserID.get();
            if (userInfo.getUserPwd().equals(password)) {
                Map<String, Object> claims =  new HashMap<>();
                claims.put("userID", userInfo.getUserID());
                claims.put("userNick", userInfo.getUserNick());
                claims.put("userAcc", userInfo.getUserAcc());

                String jwt = JwtUtils.generateJwt(claims);

                return jwt;
            }
        }
        return null;
    }
}
