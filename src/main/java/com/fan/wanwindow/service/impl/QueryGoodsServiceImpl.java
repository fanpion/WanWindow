package com.fan.wanwindow.service.impl;


import com.fan.wanwindow.dto.GoodTradeDataTendDTO;
import com.fan.wanwindow.dto.GoodTradeSellHotDTO;
import com.fan.wanwindow.entity.GoodTradeData;
import com.fan.wanwindow.entity.SysConfig;
import com.fan.wanwindow.entity.id.GoodTradeDataPK;
import com.fan.wanwindow.entity.projection.GoodSelectPrj;
import com.fan.wanwindow.entity.projection.GoodTradeDataPrice;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.repository.GoodInfoMcRepository;
import com.fan.wanwindow.repository.GoodTradeDataRepository;
import com.fan.wanwindow.repository.GoodTradeDateTendRepository;
import com.fan.wanwindow.repository.SysConfigRepository;
import com.fan.wanwindow.service.QueryGoodsService;
import com.gao.MainProcess.MainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: ODM
 * @Date: 2023-12-26 21:19
 * @Description:
 * @Version: v1.0
 */

@Service
public class QueryGoodsServiceImpl implements QueryGoodsService {

    public static final String CONFIG_KEY_COOKIE = "cookie";
    public static final String CONFIG_ID_COOKIE = "001";

    @Autowired
    GoodTradeDataRepository goodTradeDataRepository;
    @Autowired
    GoodTradeDateTendRepository goodTradeDateTendRepository;
    @Autowired
    GoodInfoMcRepository goodInfoMcRepository;
    @Autowired
    SysConfigRepository sysConfigRepository;

    @Override
    public GoodTradeData getGoodTradeData(GoodTradeDataPK goodTradeDataPK) {
        Optional<GoodTradeData> byId = goodTradeDataRepository.findById(goodTradeDataPK);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    @Override
    public List<GoodTradeDataPrice> getRecentlyPrice(String itemIndex, String dt) {
        return goodTradeDataRepository.getRecentlyPrice(itemIndex, dt);
    }

    @Override
    public List<GoodTradeDataTendDTO> getAvgPriceByWpmc(String wpmc, String fromDate, String toDate) {
        return goodTradeDateTendRepository.getGoodTradeData(wpmc, fromDate, toDate);
    }

    @Override
    public List<GoodTradeDataTendDTO> getAvgPriceByGfmc(String gfmc, String fromDate, String toDate) {
        return goodTradeDateTendRepository.getGoodTradeDataByGfmc(gfmc, fromDate, toDate);
    }

    @Override
    public String getLowPriceByGfmc(String gfmc) {
        Optional<SysConfig> byKey = sysConfigRepository.findById(CONFIG_ID_COOKIE);
        String cookie = null;
        if (byKey.isPresent()) {
            cookie = byKey.get().getValue();
        }
        return MainProcess.getGoodLowestPrice(cookie, gfmc);
    }

    @Override
    public List<GoodWpqcAndGfmc> getQcNameByWpmc(String wpmc) {
        return goodInfoMcRepository.findAllByWpqcLike(wpmc);
    }

    @Override
    public List<GoodTradeSellHotDTO> getGoodTradeDataBySellHot() {
        return goodTradeDateTendRepository.getGoodTradeDataBySellHot(100);
    }

    @Override
    public List<GoodTradeSellHotDTO> getGoodTradeDataLimitSellHot() {
        return goodTradeDateTendRepository.getGoodTradeDataLimitSellHot(10);
    }

    @Override
    public List<GoodSelectPrj> getGoodForSelect() {
        return goodInfoMcRepository.findAllForSelect();
    }
}
