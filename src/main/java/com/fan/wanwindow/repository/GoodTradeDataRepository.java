package com.fan.wanwindow.repository;

import com.fan.wanwindow.entity.GoodTradeData;
import com.fan.wanwindow.entity.id.GoodTradeDataPK;
import com.fan.wanwindow.entity.projection.GoodTradeDataPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodTradeDataRepository extends JpaRepository<GoodTradeData, GoodTradeDataPK> {
    @Query("from good_trade_data where itemIndex = ?1 and dt >= ?2")
    List<GoodTradeDataPrice> getRecentlyPrice(String itemIndex, String dt);
}
