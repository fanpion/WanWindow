package com.fan.wanwindow.entity;


import com.fan.wanwindow.entity.id.TrxMovementPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ODM
 * @Date: 2024-08-17 20:24
 * @Description:
 * @Version: v1.0
 */

@Entity(name="trxmovement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxMovement {
    @EmbeddedId
    private TrxMovementPK trxMovementPK;
}

