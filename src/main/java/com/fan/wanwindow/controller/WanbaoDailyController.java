package com.fan.wanwindow.controller;

import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.repository.GoodInfoMcRepository;
import com.gao.MainProcess.MainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wanbaodaily")
public class WanbaoDailyController {

    @Autowired
    GoodInfoMcRepository goodInfoMcRepository;

    @PostMapping(value = "/getGoodsTrade")
    public String GetGoodsTrade(String cookie){
        MainProcess.main(new String[]{"2", cookie});
        return "Request Success";
    }

    @PostMapping(value = "/getGoodDetail")
    public String getGoodDetail(int updateIDFrom) {
        for (GoodWpqcAndGfmc goodWpqcAndGfmc : goodInfoMcRepository.getGfmcByIDFrom(updateIDFrom)) {
            MainProcess.getGoodAnyStatus(goodWpqcAndGfmc.getGfmc());
        }
        return "getGoodDetail Success";
    }

}
