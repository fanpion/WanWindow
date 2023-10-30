package com.fan.wanwindow.entity.id;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSoldPK implements Serializable {
    private String userID;
    private String soldID;
}
