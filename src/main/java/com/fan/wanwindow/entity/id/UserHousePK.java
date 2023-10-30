package com.fan.wanwindow.entity.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserHousePK implements Serializable {
    private String userID;
    private String houseID;
}
