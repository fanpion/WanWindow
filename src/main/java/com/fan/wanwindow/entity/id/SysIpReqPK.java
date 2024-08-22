package com.fan.wanwindow.entity.id;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ODM
 * @Date: 2024-08-04 08:52
 * @Description:
 * @Version: v1.0
 */


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysIpReqPK implements Serializable {
    @Column(name = "ip")
    private String ip;

    @Column(name = "code")
    private String code;

    @Column(name = "continent")
    private String continent;

    @Column(name = "country")
    private String country;

    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "timezone")
    private String timezone;

    @Column(name = "accuracy")
    private String accuracy;

    @Column(name = "owner")
    private String owner;

    @Column(name = "isp")
    private String isp;

    @Column(name = "source")
    private String source;

    @Column(name = "areacode")
    private String areaCode;

    @Column(name = "adcode")
    private String adCode;

    @Column(name = "asnumber")
    private String asNumber;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;

    @Column(name = "redius")
    private String redius;

    @Column(name = "prov")
    private String prov;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "req_time")
    private Date reqTime;

    public SysIpReqPK(String ip, String code, Date reqTime){
        this.ip = ip;
        this.code = code;
        this.reqTime = reqTime;
    }

    /**
     * {
     * 	"status": 0,
     * 	"message": "Success",
     * 	"request_id": "6cc1d42267e94053a9644e5df70b56c5",
     * 	"result": {
     * 		"ip": "119.129.224.184",
     * 		"location": {
     * 			"lat": 23.15792,
     * 			"lng": 113.27324
     * 		        },
     * 		"ad_info": {
     * 			"nation": "中国",
     * 			"province": "广东省",
     * 			"city": "广州市",
     * 			"district": "白云区",
     * 			"adcode": 440111,
     * 			"nation_code": 156
     *        }    * 	}
     * }
     * @param ip
     * @param code
     * @param reqTime
     */
    public SysIpReqPK(String ip, String code, Date reqTime, String lat, String lng, String country, String prov, String city, String district, String adCode, String areaCode){
        this.ip = ip;
        this.code = code;
        this.reqTime = reqTime;

        this.lat = lat;
        this.lng = lng;
        this.country = country;
        this.prov = prov;
        this.city = city;
        this.district = district;
        this.adCode = adCode;
        this.areaCode = areaCode;
    }
}
