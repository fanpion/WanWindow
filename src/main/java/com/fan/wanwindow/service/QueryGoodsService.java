package com.fan.wanwindow.service;


import com.fan.wanwindow.dto.GoodTradeDataTendDTO;
import com.fan.wanwindow.dto.GoodTradeSellHotDTO;
import com.fan.wanwindow.entity.GoodTradeData;
import com.fan.wanwindow.entity.id.GoodTradeDataPK;
import com.fan.wanwindow.entity.projection.GoodTradeDataPrice;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ODM
 * @Date: 2023-12-25 13:58
 * @Description: Query Data of goods' info
 * @Version: v1.0
 */

public interface QueryGoodsService {
    public GoodTradeData getGoodTradeData(GoodTradeDataPK goodTradeDataPK);
    public List<GoodTradeDataPrice> getRecentlyPrice(String itemIndex, String dt);
    public List<GoodTradeDataTendDTO> getAvgPriceByWpmc(String wpmc, String fromDate, String toDate);
    public List<GoodTradeDataTendDTO> getAvgPriceByGfmc(String gfmc, String fromDate, String toDate);
    public String getLowPriceByGfmc(String gfmc);
    public List<GoodWpqcAndGfmc> getQcNameByWpmc(String wpmc);
    public List<GoodTradeSellHotDTO> getGoodTradeDataBySellHot();
    public List<GoodTradeSellHotDTO> getGoodTradeDataLimitSellHot();
}
