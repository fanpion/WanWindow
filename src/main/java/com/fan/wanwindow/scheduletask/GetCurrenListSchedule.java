package com.fan.wanwindow.scheduletask;

import com.fan.wanwindow.controller.WanbaoDailyController;
import com.gao.MainProcess.MainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
//@EnableScheduling
public class GetCurrenListSchedule {
    @Autowired
    WanbaoDailyController wanbaoDailyController;

    // 每天早上6点执行一次
    @Scheduled(cron = "0 */12 * * * ?")
    public void getCurrenList() {
        MainProcess.getDetial(100, wanbaoDailyController.getSysConfigCookie());
        System.out.println("getCurrenList exec once");
    }
}
