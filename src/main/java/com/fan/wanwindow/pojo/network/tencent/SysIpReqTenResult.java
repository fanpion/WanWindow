package com.fan.wanwindow.pojo.network.tencent;


import lombok.Data;

/**
 * @Author: ODM
 * @Date: 2024-08-04 21:13
 * @Description:
 * @Version: v1.0
 */

@Data
public class SysIpReqTenResult {
    public String ip;
    public SysIpReqTenLoc location;
    public SysIpReqTenAdInfo ad_info;
}
