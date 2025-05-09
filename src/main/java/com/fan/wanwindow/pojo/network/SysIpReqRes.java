package com.fan.wanwindow.pojo.network;


/**
 * @Author: ODM
 * @Date: 2024-08-04 09:28
 * @Description:
 * @Version: v1.0
 */

import com.fan.wanwindow.entity.SysIpReq;
import com.fan.wanwindow.entity.id.SysIpReqPK;
import com.fan.wanwindow.repository.SysIpReqRepository;
import com.fan.wanwindow.service.LogService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * {
 * 	"code": "Success",
 * 	"data": {
 * 		"continent": "亚洲",
 * 		"country": "中国",
 * 		"zipcode": "510405",
 * 		"timezone": "UTC+8",
 * 		"accuracy": "区县",
 * 		"owner": "中国电信",
 * 		"isp": "中国电信",
 * 		"source": "数据挖掘",
 * 		"areacode": "CN",
 * 		"adcode": "440111",
 * 		"asnumber": "4134",
 * 		"lat": "23.291296",
 * 		"lng": "113.319325",
 * 		"radius": "21.9706",
 * 		"prov": "广东省",
 * 		"city": "广州市",
 * 		"district": "白云区"
 * 	    },
 * 	"charge": true,
 * 	"msg": "查询成功",
 * 	"ip": "121.33.20.11",
 * 	"coordsys": "WGS84"
 * }
 */

@Data
@Component
public class SysIpReqRes extends NetworkResAbs<SysIpReqPO>{

    @Qualifier("sysIpReqLogServiceImpl")
    @Autowired
    LogService sysIpReqRes;

    public boolean charge;
    public String ip;
    public String coordsys;

    @Override
    public String toString() {
        return "SysIpReqRes{" +
                "charge=" + charge +
                ", ip='" + ip + '\'' +
                ", coordsys='" + coordsys + '\'' +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
