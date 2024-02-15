package com.fan.wanwindow.service.impl;


import com.fan.wanwindow.entity.SysConfig;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.repository.GoodInfoMcRepository;
import com.fan.wanwindow.repository.SysConfigRepository;
import com.fan.wanwindow.service.WanbaoDailyService;
import com.gao.MainProcess.MainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * @Author: ODM
 * @Date: 2023-12-26 21:47
 * @Description:
 * @Version: v1.0
 */

@Service
public class WanbaoDailyServiceImpl implements WanbaoDailyService {

    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    GoodInfoMcRepository goodInfoMcRepository;
    @Autowired
    SysConfigRepository sysConfigRepository;

    @Override
    public String GetGoodsTrade(String cookie) {
        MainProcess.main(new String[]{"2", cookie});
        return "Request Success";
    }

    @Override
    public String getGoodDetail(int updateIDFrom) {
        for (GoodWpqcAndGfmc goodWpqcAndGfmc : goodInfoMcRepository.getGfmcByIDFrom(updateIDFrom)) {
            MainProcess.getGoodAnyStatus(goodWpqcAndGfmc.getGfmc());
        }
        return "getGoodDetail Success";
    }

    @Override
    public String updateSysConfigCookie(String cookie) {
        SysConfig cookieConf = new SysConfig(
                QueryGoodsServiceImpl.CONFIG_ID_COOKIE,
                QueryGoodsServiceImpl.CONFIG_KEY_COOKIE, cookie, "Cookie for request target", simpleDateFormat.format(new Date()), null);
        sysConfigRepository.save(cookieConf);
        return "updateSysConfigCookie Complete!";
    }

    @Override
    public String getSysConfigCookie() {
        Optional<SysConfig> byKey = sysConfigRepository.findById(QueryGoodsServiceImpl.CONFIG_ID_COOKIE);
        if (byKey.isPresent()) {
            return byKey.get().getValue();
        }
        return null;
    }
}
