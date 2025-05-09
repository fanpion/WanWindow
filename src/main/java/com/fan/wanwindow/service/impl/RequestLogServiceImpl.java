package com.fan.wanwindow.service.impl;


import com.fan.wanwindow.entity.SysRequestLog;
import com.fan.wanwindow.repository.SysRequestLogRepository;
import com.fan.wanwindow.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ODM
 * @Date: 2024-08-03 10:31
 * @Description:
 * @Version: v1.0
 */

@Service
public class RequestLogServiceImpl implements LogService<SysRequestLog> {

    @Autowired
    SysRequestLogRepository sysRequestLogRepository;

    @Override
    public void log(SysRequestLog sysRequestLog) {
        sysRequestLogRepository.save(sysRequestLog);
    }
}
