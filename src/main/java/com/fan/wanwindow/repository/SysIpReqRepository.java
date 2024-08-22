package com.fan.wanwindow.repository;


import com.fan.wanwindow.entity.SysIpReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: ODM
 * @Date: 2024-08-04 10:26
 * @Description:
 * @Version: v1.0
 */

@Repository
public interface SysIpReqRepository extends JpaRepository<SysIpReq, String> {
    @Override
    <S extends SysIpReq> S save(S entity);
}
