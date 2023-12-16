package com.fan.wanwindow.repository;

import com.fan.wanwindow.entity.SysConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysConfigRepository extends JpaRepository<SysConfig, String> {
    Optional<SysConfig> findByKey(String configKey);
    Optional<SysConfig> findById(String id);


    @Override
    <S extends SysConfig> S save(S entity);
}
