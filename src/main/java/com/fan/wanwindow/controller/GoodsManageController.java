package com.fan.wanwindow.controller;


import com.fan.wanwindow.entity.TrxMovement;
import com.fan.wanwindow.entity.id.TrxMovementPK;
import com.fan.wanwindow.service.TrxManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: ODM
 * @Date: 2024-08-17 21:21
 * @Description:
 * @Version: v1.0
 */

@RestController
@RequestMapping("/goodsManage")
public class GoodsManageController {
    @Autowired
    TrxManageService trxManageService;

    @PostMapping("/addGoods")
    public void addGoods(@RequestBody List<TrxMovementPK> trxList){
        List<? extends TrxMovement> trxMovements = trxManageService.saveAll(trxList.stream().map((item)-> new TrxMovement(item)).collect(Collectors.toList()));
    }
}
