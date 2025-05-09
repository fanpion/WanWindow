package com.fan.wanwindow.controller;


import com.fan.wanwindow.annotation.WebLog;
import com.fan.wanwindow.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: ODM
 * @Date: 2023-12-27 22:14
 * @Description:
 * @Version: v1.0
 */

@Controller
@RequestMapping("/user")
@WebLog(description = "用户相关接口")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginTest", method = RequestMethod.POST)
    @WebLog(description = "用户登录")
    public ModelAndView loginTest(String username, String password, HttpServletResponse  response){
        ModelAndView modelAndView = new ModelAndView("/user/login");
        String jwt = userService.login(username, password);
        if (jwt != null){
            response.setHeader("Token", jwt);
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/loginTest1", method = RequestMethod.POST)
    @WebLog(description = "用户登录")
    public String loginTest1(String username, String password, HttpServletResponse  response){
        String resultLog = "login";
//        String jwt = userService.login(username, password);
//        if (jwt != null){
//            response.setHeader("Token", jwt);
//            resultLog = "index";
//        }
        return resultLog;
    }

    @RequestMapping(value = "/loginTest2", method = RequestMethod.POST)
    @WebLog(description = "用户登录2")
    public String loginTest2(String username, String password, HttpServletRequest request, HttpServletResponse  response) throws IOException, ServletException {
        String viewName = "login";
        String jwt = userService.login(username, password);
        if (jwt != null){
            response.setHeader("Token", jwt);
            viewName = "index";
        }
        request.getRequestDispatcher(viewName).forward(request, response);
        return viewName;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @WebLog(description = "用户登录失败, 重新登录")
    public String loginTest2(){
        String viewName = "login";
        return viewName;
    }

    @WebLog(description = "用户登录成功, 返回index")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String loginTest4(){
        String viewName = "index";
        return viewName;
    }

    @WebLog(description = "用户登录成功, 返回index2")
    @RequestMapping(value = "/index2")
    public ModelAndView loginTest5(){
        ModelAndView index = new ModelAndView("index");
        return index;
    }

    @PostMapping(value =  "/login2")
    public String loginTest3(){
        String viewName = "login";
        return viewName;
    }


}
