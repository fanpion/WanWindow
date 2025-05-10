package com.fan.repository;


import com.fan.wanwindow.WanWindowApplication;
import com.fan.wanwindow.entity.UserLeavemassage;
import com.fan.wanwindow.repository.UserLeavemessageRepository;
import com.fan.wanwindow.service.LeaveMassageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @Author: ODM
 * @Date: 2025-05-03 15:17
 * @Description:
 * @Version: v1.0
 */

@SpringBootTest(classes = WanWindowApplication.class)
public class LeaveMessageTest {

    @Autowired
    LeaveMassageService leaveMessage;

    @Test
    void saveTest(){
        //UserLeavemassage userLeavemassage = new UserLeavemassage(1, "Mytest", "Content", new Date());
        //leaveMessage.save(userLeavemassage);
    }

    @Test
    void findAllTest(){
        for (UserLeavemassage userLeavemassage : leaveMessage.findAll()) {
            System.out.println(userLeavemassage);
        }
    }



}
