package com.fan.wanwindow.repository;

import com.fan.wanwindow.entity.GoodInfoMc;
import com.fan.wanwindow.entity.projection.GoodSelectPrj;
import com.fan.wanwindow.entity.projection.GoodWpqcAndGfmc;
import com.fan.wanwindow.vo.GoodQcAndGfmcVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodInfoMcRepository extends JpaRepository<GoodInfoMc, String> {
    List<GoodWpqcAndGfmc> findAllByWpqcLike(String wpmc);

    @Query("from good_info_mc where iD+0 > ?1 ")
    List<GoodWpqcAndGfmc> getGfmcByIDFrom(int ID);

    @Query("from good_info_mc where nullif(itemIndex, '') <> '' ")
    List<GoodSelectPrj> findAllForSelect();
}
