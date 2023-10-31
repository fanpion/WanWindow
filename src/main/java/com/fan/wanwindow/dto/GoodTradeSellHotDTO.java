package com.fan.wanwindow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodTradeSellHotDTO {
    private String info;
    private String sellCnt30;
    private String avgPrice;
    private String wpmc;
    //private String wpqc;
}
