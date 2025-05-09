package com.fan.wanwindow.pojo.network;


/**
 * @Author: ODM
 * @Date: 2024-08-04 09:57
 * @Description:
 * @Version: v1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * "data": {
 *  * 		"continent": "亚洲",
 *  * 		"country": "中国",
 *  * 		"zipcode": "510405",
 *  * 		"timezone": "UTC+8",
 *  * 		"accuracy": "区县",
 *  * 		"owner": "中国电信",
 *  * 		"isp": "中国电信",
 *  * 		"source": "数据挖掘",
 *  * 		"areacode": "CN",
 *  * 		"adcode": "440111",
 *  * 		"asnumber": "4134",
 *  * 		"lat": "23.291296",
 *  * 		"lng": "113.319325",
 *  * 		"radius": "21.9706",
 *  * 		"prov": "广东省",
 *  * 		"city": "广州市",
 *  * 		"district": "白云区"
 *  * 	    },
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysIpReqPO {
    public String continent;
    public String country;
    public String zipcode;
    public String timezone;
    public String accuracy;
    public String owner;
    public String isp;
    public String source;
    public String areacode;
    public String adcode;
    public String asnumber;
    public String lat;
    public String lng;
    public String redius;
    public String prov;
    public String city;
    public String district;
}
