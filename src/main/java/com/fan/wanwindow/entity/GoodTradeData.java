package com.fan.wanwindow.entity;

import com.fan.wanwindow.entity.id.GoodTradeDataPK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity(name = "good_trade_data")
@IdClass(GoodTradeDataPK.class)
@Data
public class GoodTradeData {
    @Id
    @Column(name = "item_index")
    private String itemIndex;

    @Id
    @Column(name = "dt")
    private String dt;

    @Column(name = "max_price")
    private String maxPrice;

    @Column(name = "avg_price_30")
    private String avgPrice30;

    @Column(name = "sell_cnt_30")
    private String sellCnt30;

    @Column(name = "follow_heat_30")
    private String followHeat30;

    @Column(name = "avg_price")
    private String avgPrice;
}
