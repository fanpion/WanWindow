package com.fan.wanwindow.entity.id;


import com.fan.wanwindow.entity.TrxMovement;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: ODM
 * @Date: 2024-08-17 20:26
 * @Description:
 * @Version: v1.0
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrxMovementPK extends TrxMovement implements Serializable {
    @Column(name = "user_id")
    private String userId;

    @Column(name = "trx_no")
    private String trxNo;

    @Column(name = "good_item")
    private String goodItem;

    @Column(name = "trx_type")
    private String trxType;

    @Column(name = "trx_price")
    private double trxPrice;

    @Column(name = "trx_quanlity")
    private int trxQuanlity;

    @Column(name = "trx_amt")
    private double trxAmt;

    @Column(name = "trx_date")
    private Date trxDate;

    @Column(name = "trx_source")
    private String trxSource;

    @Column(name = "trx_way")
    private String trxWay;

    @Column(name = "trx_role")
    private String trxRole;

    @Column(name = "pay_way")
    private String payWay;

    @Column(name = "trx_status")
    private String trxStatus;

    @Column(name = "from_trx")
    private String fromTrx;


}
