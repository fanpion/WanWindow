package com.fan.wanwindow.pojo.network.tencent;


import com.fan.wanwindow.pojo.network.NetworkReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ODM
 * @Date: 2024-08-04 21:19
 * @Description:
 * @Version: v1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class NetworkReqAbs implements NetworkReq {
    public String initUrl;
    public String finalUrl;

    public NetworkReqAbs(String url) {
        this.initUrl = url;
    }
}
