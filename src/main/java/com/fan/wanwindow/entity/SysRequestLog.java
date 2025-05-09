package com.fan.wanwindow.entity;


import com.fan.wanwindow.entity.id.SysRequestLogPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: ODM
 * @Date: 2024-08-03 10:33
 * @Description:
 * @Version: v1.0
 */

@Entity(name = "sys_request_log" )
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysRequestLog {

    @EmbeddedId
    private SysRequestLogPK sysRequestLogPK;
}
