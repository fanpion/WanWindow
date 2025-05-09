package com.fan.wanwindow.controller;


import com.fan.wanwindow.annotation.WebLog;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ODM
 * @Date: 2024-08-03 15:27
 * @Description:
 * @Version: v1.0
 */

@Controller
@RequestMapping("/log")

@WebLog(description = "rlog")
public class SysLogController {
    @GetMapping("/welcome")
    public ResponseEntity<Void> welcome(String path){
        System.out.println("welcome!!!"+path);
        return ResponseEntity.ok().build();
    }
}
