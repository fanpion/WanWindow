package com.fan.wanwindow.repository;

import com.fan.wanwindow.entity.UserLeavemassage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLeavemessageRepository extends JpaRepository<UserLeavemassage, Integer> {

    @Override
    List<UserLeavemassage> findAll();

    @Override
    <S extends UserLeavemassage> S save(S entity);
}
