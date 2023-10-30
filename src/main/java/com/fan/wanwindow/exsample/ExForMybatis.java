package com.fan.wanwindow.exsample;

import com.gao.dao.GoodIndexInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ExForMybatis {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsFile = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSession build = new SqlSessionFactoryBuilder().build(resourceAsFile).openSession();
        GoodIndexInfoMapper mapper = build.getMapper(GoodIndexInfoMapper.class);
        List<String> consignmentIds = mapper.selectAllConsignmentId();
        for (int i = 0;i < consignmentIds.size();i++){
            System.out.println(consignmentIds.get(i));
        }
    }
}
