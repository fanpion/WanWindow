package com.fan.wanwindow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "sys_config" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysConfig {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "key")
    private String key;

    @Column(name = "value")
    private String value;

    @Column(name = "desc")
    private String desc;

    @Column(name = "dt")
    private String dt;

    @Column(name = "remark")
    private String remark;
}
