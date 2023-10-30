package com.fan.repository;


import com.fan.wanwindow.WanWindowApplication;
import com.fan.wanwindow.dto.GoodTradeDataTendDTO;
import com.fan.wanwindow.repository.GoodTradeDateTendRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = WanWindowApplication.class)
public class GoodTradeDataTendRepositoryTest {

    @Autowired
    private GoodTradeDateTendRepository goodTradeDateTendRepository;

    @Test
    void getGoodTradeDataTendVOByWpqc() {
        List<GoodTradeDataTendDTO> list = goodTradeDateTendRepository.getGoodTradeData("蓝兔盒子", "2023-09-13", "2023-10-13");
            for (GoodTradeDataTendDTO goodTradeDataTendVO : list) {
                System.out.println(goodTradeDataTendVO);
            }
    }

}
