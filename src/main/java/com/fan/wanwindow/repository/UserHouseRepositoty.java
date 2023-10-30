package com.fan.wanwindow.repository;

import com.fan.wanwindow.entity.UserHouse;
import com.fan.wanwindow.entity.id.UserHousePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHouseRepositoty extends JpaRepository<UserHouse, UserHousePK> {
}
