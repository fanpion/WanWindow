package com.fan.wanwindow.entity.id;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ODM
 * @Date: 2024-08-03 15:45
 * @Description:
 * @Version: v1.0
 */

@Embeddable
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysRequestLogPK implements Serializable {
    @Column(name = "log_url")
    private String logUrl;

    @Column(name = "log_des")
    private String logDes;

    @Column(name = "log_http_method")
    private String logHttpMethod;

    @Column(name = "log_class")
    private String logClass;

    @Column(name = "log_method")
    private String logMethod;

    @Column(name = "log_ip")
    private String logIp;

    @Column(name = "log_ip_addr")
    private String logIpAddr;

    @Column(name = "log_params_value")
    private String logParamsValue;

    @Column(name = "log_params_key")
    private String logParamsKey;

    @Column(name = "log_time")
    private Date logTime;
}
