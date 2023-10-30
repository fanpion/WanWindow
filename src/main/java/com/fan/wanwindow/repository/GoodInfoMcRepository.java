package com.fan.wanwindow.repository;

import com.fan.wanwindow.entity.GoodInfoMc;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.vo.GoodQcAndGfmcVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodInfoMcRepository extends JpaRepository<GoodInfoMc, String> {
    List<GoodWpqcAndGfmc> findAllByWpqcLike(String wpmc);
}
