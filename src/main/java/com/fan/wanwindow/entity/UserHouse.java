package com.fan.wanwindow.entity;

import com.fan.wanwindow.entity.id.UserHousePK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity(name = "user_house")
@IdClass(UserHousePK.class)
@Data
public class UserHouse {
    @Id
    @Column(name = "user_id")
    private String userID;

    @Id
    @Column(name = "house_id")
    private String houseID;

    @Column(name = "item_index")
    private String itemIndex;

    @Column(name = "house_num")
    private String houseNum;

    @Column(name = "house_price")
    private Double housePrice;

    @Column(name = "house_status")
    private String houseStatus;

    @Column(name = "seasun_role")
    private String seasunRole;

    @Column(name = "server_id")
    private String serverID;

    @Column(name = "house_dt")
    private String houseDt;
}
