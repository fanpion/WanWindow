package com.fan.wanwindow.pojo.network.tencent;


import com.fan.wanwindow.pojo.network.NetworkReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ODM
 * @Date: 2024-08-04 21:07
 * @Description:
 * @Version: v1.0
 */

/**
 * {"status":375,"message":"局域网IP","request_id":"7957e31563664b9b9aff4c3bdc4ba272"}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysIpReqTenPO {
    public String status;
    public String message;
    public SysIpReqTenResult result;
    public String request_id;
}
