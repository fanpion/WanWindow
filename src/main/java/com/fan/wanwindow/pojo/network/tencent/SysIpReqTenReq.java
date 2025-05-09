package com.fan.wanwindow.pojo.network.tencent;


import com.fan.wanwindow.pojo.network.NetworkReq;
import lombok.Data;

/**
 * @Author: ODM
 * @Date: 2024-08-04 21:19
 * @Description:
 * @Version: v1.0
 */

@Data
public class SysIpReqTenReq extends NetworkReqAbs {
    public String desIP;

    public SysIpReqTenReq(String desIP){
        super("https://apis.map.qq.com/ws/location/v1/ip?ip=%s&key=2GXBZ-DQ66P-LYEDV-VSQO2-UDGYZ-INBQT");
        this.desIP = desIP;
        this.finalUrl = String.format(initUrl, desIP);
    }

    @Override
    public NetworkReq merge() {
        return this;
    }
}
