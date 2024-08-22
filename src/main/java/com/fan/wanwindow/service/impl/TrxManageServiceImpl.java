package com.fan.wanwindow.service.impl;


import com.fan.wanwindow.entity.TrxMovement;
import com.fan.wanwindow.repository.TrxMovementRepository;
import com.fan.wanwindow.service.TrxManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ODM
 * @Date: 2024-08-17 21:10
 * @Description:
 * @Version: v1.0
 */

@Service
public class TrxManageServiceImpl implements TrxManageService {
    @Autowired
    TrxMovementRepository trxMovementRepository;

    @Override
    public <S extends TrxMovement> S save(S entity) {
        return trxMovementRepository.save(entity);
    }

    @Override
    public <S extends TrxMovement> List<S> saveAll(Iterable<S> entities) {
        return trxMovementRepository.saveAll(entities);
    }
}
