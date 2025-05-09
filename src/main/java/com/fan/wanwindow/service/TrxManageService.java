package com.fan.wanwindow.service;

import com.fan.wanwindow.entity.TrxMovement;

import java.util.List;

public interface TrxManageService {
    <S extends TrxMovement> S save(S entity);

    <S extends TrxMovement> List<S> saveAll(Iterable<S> entities);
}
