package com.fan.wanwindow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "user_account")
@Data
public class UserAccount {
    @Id
    @Column(name = "user_id")
    private String userID;

    @Column(name = "seasun_acc")
    private String seasunAcc;

    @Column(name = "seasun_role")
    private String seasunRole;

    @Column(name = "server_id")
    private String serverID;
}
