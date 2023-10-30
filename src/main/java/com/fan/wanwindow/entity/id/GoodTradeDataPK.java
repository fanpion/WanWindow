package com.fan.wanwindow.entity.id;

import lombok.Data;

import java.io.Serializable;


@Data
public class GoodTradeDataPK implements Serializable {
    private String itemIndex;
    private String dt;
}
