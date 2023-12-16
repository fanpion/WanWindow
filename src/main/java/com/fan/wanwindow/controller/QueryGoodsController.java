package com.fan.wanwindow.controller;

import com.fan.wanwindow.dto.GoodTradeDataTendDTO;
import com.fan.wanwindow.dto.GoodTradeSellHotDTO;
import com.fan.wanwindow.entity.GoodTradeData;
import com.fan.wanwindow.entity.SysConfig;
import com.fan.wanwindow.entity.id.GoodTradeDataPK;
import com.fan.wanwindow.entity.projection.GoodTradeDataPrice;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.repository.GoodInfoMcRepository;
import com.fan.wanwindow.repository.GoodTradeDataRepository;
import com.fan.wanwindow.repository.GoodTradeDateTendRepository;
import com.fan.wanwindow.repository.SysConfigRepository;
import com.fan.wanwindow.vo.GoodQcAndGfmcVO;
import com.gao.MainProcess.MainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/querygoods")
public class QueryGoodsController {

    public static final String CONFIG_KEY_COOKIE = "cookie";
    public static final String CONFIG_ID_COOKIE = "001";


    @RequestMapping("/testHello")
    public void testHello(){
        System.out.println("Hello World!");
    }


    @Autowired
    GoodTradeDataRepository goodTradeDataRepository;
    @Autowired
    GoodTradeDateTendRepository goodTradeDateTendRepository;
    @Autowired
    GoodInfoMcRepository goodInfoMcRepository;
    @Autowired
    SysConfigRepository sysConfigRepository;

    @PostMapping("/getGoodTradeData")
    public GoodTradeData getGoodTradeData(@RequestBody GoodTradeDataPK goodTradeDataPK){
        GoodTradeData goodTradeData = null;
        Optional<GoodTradeData> byId = goodTradeDataRepository.findById(goodTradeDataPK);
        if (byId.isPresent()) {
            goodTradeData = byId.get();
            System.out.println(goodTradeData);
        }
        return goodTradeData;
    }

    @PostMapping("/getRecentlyPrice")
    public List<GoodTradeDataPrice> getRecentlyPrice(String itemIndex, String dt){
        List<GoodTradeDataPrice> byId = null;
        byId = goodTradeDataRepository.getRecentlyPrice(itemIndex, dt);
        return byId;
    }

    @PostMapping("/getAvgPriceByWpmc")
    public List<GoodTradeDataTendDTO> getAvgPriceByWpmc(String wpmc, String fromDate, String toDate){
        List<GoodTradeDataTendDTO> byWpmc = null;
        byWpmc = goodTradeDateTendRepository.getGoodTradeData(wpmc, fromDate, toDate);
        return byWpmc;
    }

    @PostMapping("/getAvgPriceByGfmc")
    public List<GoodTradeDataTendDTO> getAvgPriceByGfmc(String gfmc, String fromDate, String toDate){
        List<GoodTradeDataTendDTO> byWpmc = null;
        byWpmc = goodTradeDateTendRepository.getGoodTradeDataByGfmc(gfmc, fromDate, toDate);
        return byWpmc;
    }

    @PostMapping("/getLowPriceByGfmc")
    public String getLowPriceByGfmc(String gfmc){
        Optional<SysConfig> byKey = sysConfigRepository.findById(CONFIG_ID_COOKIE);
        String cookie = null;
        if (byKey.isPresent()) {
            cookie = byKey.get().getValue();
        }
        return MainProcess.getGoodLowestPrice(cookie, gfmc);
    }


    @PostMapping("/getQcNameByWpmc")
    public List<GoodWpqcAndGfmc> getQcNameByWpmc(String wpmc){
        List<GoodWpqcAndGfmc> qcName = null;
        qcName = goodInfoMcRepository.findAllByWpqcLike(wpmc);
        return qcName;
    }

    @GetMapping("/getGoodTradeDataBySellHot")
    public List<GoodTradeSellHotDTO> getGoodTradeDataBySellHot() {
        List<GoodTradeSellHotDTO> bySellHot = null;
        bySellHot = goodTradeDateTendRepository.getGoodTradeDataBySellHot(100);
        return bySellHot;
    }

    @GetMapping("/getGoodTradeDataLimitSellHot")
    public List<GoodTradeSellHotDTO> getGoodTradeDataLimitSellHot() {
        List<GoodTradeSellHotDTO> bySellHot = null;
        bySellHot = goodTradeDateTendRepository.getGoodTradeDataLimitSellHot(10);
        return bySellHot;
    }

}
