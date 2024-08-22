package com.fan.wanwindow.repository;

import com.fan.wanwindow.entity.TrxMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrxMovementRepository extends JpaRepository<TrxMovement, String> {
    @Override
    <S extends TrxMovement> S save(S entity);

    @Override
    <S extends TrxMovement> List<S> saveAll(Iterable<S> entities);
}
