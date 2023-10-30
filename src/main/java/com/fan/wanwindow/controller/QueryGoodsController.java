package com.fan.wanwindow.controller;

import com.fan.wanwindow.dto.GoodTradeDataTendDTO;
import com.fan.wanwindow.entity.GoodTradeData;
import com.fan.wanwindow.entity.id.GoodTradeDataPK;
import com.fan.wanwindow.entity.projection.GoodTradeDataPrice;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.repository.GoodInfoMcRepository;
import com.fan.wanwindow.repository.GoodTradeDataRepository;
import com.fan.wanwindow.repository.GoodTradeDateTendRepository;
import com.fan.wanwindow.vo.GoodQcAndGfmcVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/querygoods")
public class QueryGoodsController {


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

    @PostMapping("/getQcNameByWpmc")
    public List<GoodWpqcAndGfmc> getQcNameByWpmc(String wpmc){
        List<GoodWpqcAndGfmc> qcName = null;
        qcName = goodInfoMcRepository.findAllByWpqcLike(wpmc);
        return qcName;
    }
}
