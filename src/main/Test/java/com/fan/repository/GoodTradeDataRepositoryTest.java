package com.fan.repository;

import com.fan.wanwindow.WanWindowApplication;
import com.fan.wanwindow.entity.GoodTradeData;
import com.fan.wanwindow.entity.id.GoodTradeDataPK;
import com.fan.wanwindow.entity.projection.GoodTradeDataPrice;
import com.fan.wanwindow.repository.GoodTradeDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = WanWindowApplication.class)
class GoodTradeDataRepositoryTest {
    @Autowired
    private GoodTradeDataRepository goodTradeDataRepository;

    @Test
    void FindByIdTest() {
        GoodTradeDataPK goodTradeDataPK = new GoodTradeDataPK();
        goodTradeDataPK.setDt("2023-10-07");
        goodTradeDataPK.setItemIndex("3980");
        Optional<GoodTradeData> byId = goodTradeDataRepository.findById(goodTradeDataPK);
        if (byId.isPresent()) {
            System.out.println(byId.get());
        }
    }

    @Test
    void getRecentlyPriceTest() {
        GoodTradeDataPK goodTradeDataPK = new GoodTradeDataPK();
        goodTradeDataPK.setDt("2023-08-07");
        goodTradeDataPK.setItemIndex("3980");
        List<GoodTradeDataPrice> byId = goodTradeDataRepository.getRecentlyPrice("3980", "2023-08-07");
        for (GoodTradeDataPrice goodTradeData : byId) {
            System.out.println(goodTradeData);
        }
    }


}
