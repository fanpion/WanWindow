package com.fan.wanwindow.controller;

import com.gao.MainProcess.MainProcess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wanbaodaily")
public class WanbaoDailyController {

    @PostMapping(value = "/getGoodsTrade")
    public String GetGoodsTrade(String cookie){
        MainProcess.main(new String[]{"2", cookie});
        return "Request Success";
    }

}
