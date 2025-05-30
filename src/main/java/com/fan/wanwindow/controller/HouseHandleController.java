package com.fan.wanwindow.controller;

import com.fan.wanwindow.entity.UserHouse;
import com.fan.wanwindow.repository.UserHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/houseHandle")
public class HouseHandleController {

    @Autowired
    UserHouseRepository userHouseRepositoty;

    @RequestMapping("/goodSave")
    public void goodSave(UserHouse userHouse) {
        System.out.println(userHouse);
        userHouseRepositoty.save(userHouse);
    }

}
