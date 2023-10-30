package com.fan.wanwindow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodTradeDataTendDTO {
    /**
     * 通称
     */
    private String wpqc;
    private String info;
    private String maxPrice;
    private String avgPrice30;
    private String sellCnt30;
    private String followHeat30;
    private String dt;
    private String avgPrice;
}
