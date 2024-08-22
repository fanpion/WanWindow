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
public class SysIpReqReq implements NetworkReq {
    public String initUrl = "https://qifu.baidu.com/ip/geo/v1/district?ip=%s";
    public String desIp;
    public String finalUrl;

    public SysIpReqReq(String desIp){
        this.desIp = desIp;
    }

    @Override
    public SysIpReqReq merge() {
        this.finalUrl = String.format(initUrl, desIp);
        System.out.println(finalUrl);
        return this;
    }
}
