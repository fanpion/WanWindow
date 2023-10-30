package com.fan.wanwindow.entity;

import com.fan.wanwindow.entity.id.UserHousePK;
import com.fan.wanwindow.entity.id.UserSoldPK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity(name = "user_sold")
@IdClass(UserSoldPK.class)
@Data
public class UserSold {
    @Id
    @Column(name = "user_id")
    private String userID;

    @Id
    @Column(name = "sold_id")
    private String soldID;

    @Column(name = "house_id")
    private String houseID;

    @Column(name = "item_index")
    private String itemIndex;

    @Column(name = "sold_num")
    private String soldNum;

    @Column(name = "sold_price")
    private Double soldPrice;

    @Column(name = "sold_fee_rate")
    private String soldFeeRate;

    @Column(name = "sold_inc")
    private String soldInc;

    @Column(name = "sold_channel")
    private String soldChannel;

    @Column(name = "seasun_role")
    private String seasunRole;

    @Column(name = "server_id")
    private String serverID;

    @Column(name = "sold_dt")
    private String soldDt;
}
