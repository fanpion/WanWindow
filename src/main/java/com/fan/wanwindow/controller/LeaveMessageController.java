package com.fan.wanwindow.controller;


import com.fan.wanwindow.annotation.WebLog;
import com.fan.wanwindow.entity.UserLeavemassage;
import com.fan.wanwindow.service.LeaveMassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ODM
 * @Date: 2025-05-03 16:11
 * @Description:
 * @Version: v1.0
 */

@RestController
@RequestMapping("/leavemessage")
@WebLog(description = "leavemessage")
public class LeaveMessageController {

    @Autowired
    LeaveMassageService leaveMassageService;

    @RequestMapping("/findall")
    public List<UserLeavemassage> findAll(){
        return leaveMassageService.findAll();
    }

    @RequestMapping("/save")
    public void save(UserLeavemassage userLeavemassage){
        leaveMassageService.save(userLeavemassage);
    }
}
