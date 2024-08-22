package com.fan.wanwindow.service.impl;


import com.fan.wanwindow.entity.SysIpReq;
import com.fan.wanwindow.repository.SysIpReqRepository;
import com.fan.wanwindow.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ODM
 * @Date: 2024-08-04 14:38
 * @Description:
 * @Version: v1.0
 */

@Service
public class SysIpReqLogServiceImpl implements LogService<SysIpReq> {

    @Autowired
    SysIpReqRepository sysIpReqRepository;

    @Override
    public void log(SysIpReq sysIpReq) {
        sysIpReqRepository.save(sysIpReq);
    }
}
