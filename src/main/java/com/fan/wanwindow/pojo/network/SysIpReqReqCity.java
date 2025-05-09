package com.fan.wanwindow.pojo.network;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ODM
 * @Date: 2024-08-04 09:15
 * @Description:
 * @Version: v1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysIpReqReqCity implements NetworkReq {
    public String initUrl = "https://api.ipplus360.com/ip/geo/v1/city/?key=u2beUieYLBrDJJnVjEHZGmE43COmIfQ5lBaWWhYzz8WgcqlxwNJpYH7JxPNpZNqe&ip=%s&coordsys=WGS84";
    public String desIp;
    public String finalUrl;

    public SysIpReqReqCity(String desIp){
        this.desIp = desIp;
    }

    @Override
    public SysIpReqReqCity merge() {
        this.finalUrl = String.format(initUrl, desIp);
        System.out.println(finalUrl);
        return this;
    }
}
