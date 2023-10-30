package com.fan.wanwindow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "user_info")
@Data
public class UserInfo {
    @Id
    @Column(name = "user_id")
    private String userID;

    @Column(name = "user_nick")
    private String userNick;

    @Column(name = "user_acc")
    private String userAcc;

    @Column(name = "user_pwd")
    private String userPwd;
}
