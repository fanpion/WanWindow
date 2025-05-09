package com.fan.wanwindow.controller;

import com.fan.wanwindow.annotation.WebLog;
import com.fan.wanwindow.entity.SysConfig;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.repository.GoodInfoMcRepository;
import com.fan.wanwindow.repository.SysConfigRepository;
import com.fan.wanwindow.service.WanbaoDailyService;
import com.fan.wanwindow.service.impl.QueryGoodsServiceImpl;
import com.gao.MainProcess.MainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/wanbaodaily")
@WebLog(description = "wanbaodaily")
public class WanbaoDailyController {

    @Autowired
    WanbaoDailyService wanbaoDailyService;

    @PostMapping(value = "/getGoodsTrade")
    public String GetGoodsTrade(String cookie){
        return wanbaoDailyService.GetGoodsTrade(cookie);
    }

    @PostMapping(value = "/getGoodDetail")
    public String getGoodDetail(int updateIDFrom) {
        return wanbaoDailyService.getGoodDetail(updateIDFrom);
    }

    @PostMapping(value = "/updateSysConfigCookie")
    public String updateSysConfigCookie(String cookie) {
        return wanbaoDailyService.updateSysConfigCookie(cookie);
    }

    @WebLog(description = "Get SysConfig Cookie")
    @GetMapping(value = "/getSysConfigCookie")
    public String getSysConfigCookie() {
        return wanbaoDailyService.getSysConfigCookie();
    }

}
