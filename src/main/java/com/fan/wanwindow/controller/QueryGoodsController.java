package com.fan.wanwindow.controller;

import com.fan.wanwindow.annotation.WebLog;
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
import com.fan.wanwindow.service.QueryGoodsService;
import com.gao.MainProcess.MainProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/querygoods")
@WebLog(description = "querygoods")
public class QueryGoodsController {

    @RequestMapping("/testHello")
    public void testHello(){
        System.out.println("Hello World!");
    }

    @Autowired
    QueryGoodsService queryGoodsService;

    @PostMapping("/getGoodTradeData")
    public GoodTradeData getGoodTradeData(@RequestBody GoodTradeDataPK goodTradeDataPK){
        return queryGoodsService.getGoodTradeData(goodTradeDataPK);
    }

    @PostMapping("/getRecentlyPrice")
    public List<GoodTradeDataPrice> getRecentlyPrice(String itemIndex, String dt){
        return queryGoodsService.getRecentlyPrice(itemIndex, dt);
    }

    @PostMapping("/getAvgPriceByWpmc")
    public List<GoodTradeDataTendDTO> getAvgPriceByWpmc(String wpmc, String fromDate, String toDate){
        return queryGoodsService.getAvgPriceByWpmc(wpmc, fromDate, toDate);
    }

    @PostMapping("/getAvgPriceByGfmc")
    public List<GoodTradeDataTendDTO> getAvgPriceByGfmc(String gfmc, String fromDate, String toDate){
        return queryGoodsService.getAvgPriceByGfmc(gfmc, fromDate, toDate);
    }

    @PostMapping("/getLowPriceByGfmc")
    public String getLowPriceByGfmc(String gfmc){
        return queryGoodsService.getLowPriceByGfmc(gfmc);
    }


    @PostMapping("/getQcNameByWpmc")
    public List<GoodWpqcAndGfmc> getQcNameByWpmc(String wpmc){
        return queryGoodsService.getQcNameByWpmc(wpmc);
    }

    @GetMapping("/getGoodTradeDataBySellHot")
    public List<GoodTradeSellHotDTO> getGoodTradeDataBySellHot() {
        return queryGoodsService.getGoodTradeDataBySellHot();
    }

    @GetMapping("/getGoodTradeDataLimitSellHot")
    public List<GoodTradeSellHotDTO> getGoodTradeDataLimitSellHot() {
        return queryGoodsService.getGoodTradeDataLimitSellHot();
    }

}
