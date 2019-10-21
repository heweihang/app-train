package com.epicc.apptrain;

import com.epicc.apptrain.system.dao.TrainUserMapper;
import com.epicc.apptrain.system.model.TrainUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Title:TestClsss
 * @Description;ToDo
 * @Author: wangpan
 * @Date 2019/10/18 0018 上午 10:30
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=AppTrainApplication.class)
public class TestClsss {
    @Autowired
    private TrainUserMapper trainUserMapper;

    @Test
    public void test1(){
        Long lo=Long.parseLong("1");
        TrainUser addressById = trainUserMapper.findTrainUserById(lo);
        System.out.println("测试开始---");
        System.out.println(addressById.toString());
        System.out.println("测试结束---");

    }



}
