package com.fan.wanwindow.repository;

import com.fan.wanwindow.dto.GoodTradeDataTendDTO;
import com.fan.wanwindow.entity.GoodTradeData;
import com.fan.wanwindow.entity.id.GoodTradeDataPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodTradeDateTendRepository extends JpaRepository<GoodTradeData, GoodTradeDataPK> {

    @Query(value = "select new com.fan.wanwindow.dto.GoodTradeDataTendDTO(a.wpqc,b.info, c.maxPrice, c.avgPrice30, c.sellCnt30, c.followHeat30, c.dt, c.avgPrice) " +
            "from good_info_mc a " +
            "LEFT JOIN good_index_info_rel b " +
            "on a.gfmc = b.info " +
            "LEFT JOIN good_trade_data c " +
            "on b.itemIndex = c.itemIndex " +
            "where a.wpqc like %?1% and c.dt >= ?2 and c.dt <= ?3 " +
            "order by c.itemIndex, c.dt")
    List<GoodTradeDataTendDTO> getGoodTradeData(String wpqc, String fromDate, String toDate);

    @Query(value = "select new com.fan.wanwindow.dto.GoodTradeDataTendDTO('',a.info, b.maxPrice, b.avgPrice30, b.sellCnt30, b.followHeat30, b.dt, b.avgPrice) " +
            "from good_index_info_rel a " +
            "left join good_trade_data b " +
            "on a.itemIndex = b.itemIndex " +
            "where a.info = ?1 and b.dt >= ?2 and b.dt <= ?3 " +
            "order by b.dt")
    List<GoodTradeDataTendDTO> getGoodTradeDataByGfmc(String gfmc, String fromDate, String toDate);
}
