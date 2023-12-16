package com.fan.wanwindow.controller;

import com.fan.wanwindow.entity.SysConfig;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.repository.GoodInfoMcRepository;
import com.fan.wanwindow.repository.SysConfigRepository;
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
public class WanbaoDailyController {
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    GoodInfoMcRepository goodInfoMcRepository;
    @Autowired
    SysConfigRepository sysConfigRepository;


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

    @PostMapping(value = "/updateSysConfigCookie")
    public String updateSysConfigCookie(String cookie) {
        SysConfig cookieConf = new SysConfig(
                QueryGoodsController.CONFIG_ID_COOKIE,
                QueryGoodsController.CONFIG_KEY_COOKIE, cookie, "Cookie for request target", simpleDateFormat.format(new Date()), null);
        sysConfigRepository.save(cookieConf);
        return "updateSysConfigCookie Complete!";
    }

    @GetMapping(value = "/getSysConfigCookie")
    public String getSysConfigCookie() {
        Optional<SysConfig> byKey = sysConfigRepository.findById(QueryGoodsController.CONFIG_ID_COOKIE);
        String cookie = null;
        if (byKey.isPresent()) {
            cookie = byKey.get().getValue();
        }
        return cookie;
    }

}
