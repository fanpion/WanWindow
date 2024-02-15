package com.fan.wanwindow.controller;


import com.fan.wanwindow.annotation.WebLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ODM
 * @Date: 2023-12-31 22:47
 * @Description:
 * @Version: v1.0
 */

@Controller
@RequestMapping("/special/forLuBao")
public class SpecialController {

    @RequestMapping("/happy_new_year_2024")
    @WebLog(description = "用户登录3")
    public String loginTest2(){
        String viewName = "happy_new_year_2024";
        return viewName;
    }

    @RequestMapping("/four_huai_med")
    @WebLog(description = "用户登录3")
    public String fourHuaiMed(){
        String viewName = "four_huai_med";
        return viewName;
    }

    @RequestMapping("/happy_god_of_wealth")
    @WebLog(description = "happy_god_of_wealth")
    public String fourGODWealth(){
        String viewName = "happy_god_of_wealth";
        return viewName;
    }
}
