package com.fan.wanwindow.service.impl;


import com.fan.wanwindow.entity.UserLeavemassage;
import com.fan.wanwindow.repository.UserLeavemessageRepository;
import com.fan.wanwindow.service.LeaveMassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ODM
 * @Date: 2025-05-03 15:14
 * @Description:
 * @Version: v1.0
 */

@Service
public class LeaveMessageImpl implements LeaveMassageService {

    @Autowired
    UserLeavemessageRepository leaveMassageService;

    @Override
    public List<UserLeavemassage> findAll() {
        return leaveMassageService.findAll();
    }

    @Override
    public void save(UserLeavemassage message) {
        leaveMassageService.save(message);
    }
}
