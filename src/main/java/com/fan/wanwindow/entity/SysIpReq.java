package com.fan.wanwindow.entity;


import com.fan.wanwindow.entity.id.SysIpReqPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ODM
 * @Date: 2024-08-04 08:59
 * @Description:
 * @Version: v1.0
 */

@Entity(name = "sys_ip_req")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysIpReq {
    @EmbeddedId
    private SysIpReqPK sysIpReqPK;
}
