package com.fan.wanwindow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "good_info_mc")
@Data
public class GoodInfoMc {
    @Id
    @Column(name = "ID")
    private String iD;

    @Column(name = "Lb")
    private String lb;

    @Column(name = "Wpmc")
    private String wpmc;

    @Column(name = "Wpqc")
    private String wpqc;

    @Column(name = "Xl")
    private String xl;

    @Column(name = "Tp")
    private String tp;

    @Column(name = "Cxfl")
    private String cxfl;

    @Column(name = "Yj")
    private String yj;

    @Column(name = "Gfmc")
    private String gfmc;
}
