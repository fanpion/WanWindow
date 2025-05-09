package com.fan.wanwindow.repository;

import com.fan.wanwindow.entity.SysRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRequestLogRepository extends JpaRepository<SysRequestLog, String> {

    @Override
    <S extends SysRequestLog> S save(S entity);
}
