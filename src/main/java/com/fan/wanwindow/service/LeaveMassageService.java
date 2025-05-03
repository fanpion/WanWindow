package com.fan.wanwindow.service;

import com.fan.wanwindow.entity.UserLeavemassage;

import java.util.List;

public interface LeaveMassageService {
    List<UserLeavemassage> findAll();

    void save(UserLeavemassage message);
}
