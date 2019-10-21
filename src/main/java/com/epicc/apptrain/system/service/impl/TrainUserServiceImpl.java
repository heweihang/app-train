package com.epicc.apptrain.system.service.impl;

import com.epicc.apptrain.system.dao.TrainUserMapper;
import com.epicc.apptrain.system.model.TrainMenu;
import com.epicc.apptrain.system.model.TrainUser;
import com.epicc.apptrain.system.service.TrainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title:TrainUserImpl
 * @Description;ToDo
 * @Author: wangpan
 * @Date 2019/10/18 0018 上午 9:41
 * @Version: 1.0
 */
@Service
public class TrainUserServiceImpl implements TrainUserService {

    @Autowired
    private TrainUserMapper trainUserMapper;

    public TrainUser findTrainUser(long id){
        TrainUser addressById = trainUserMapper.findTrainUserById(id);
        return addressById;
    }

    public int modifyTrainUser(TrainUser trainUser){
        int i = trainUserMapper.modifyTrainUser(trainUser);
        return i;
    }

    //------------------------train menu

    public TrainMenu findTrainMenu(long id){
        TrainMenu trainMenuById = trainUserMapper.findTrainMenuById(id);
        return trainMenuById;
    }

    public int modifyTrainMenu(TrainMenu trainMenu){
        int i = trainUserMapper.modifyTrainMenu(trainMenu);
        return i;
    }



}
