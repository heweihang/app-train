package com.epicc.apptrain.system.service;

import com.epicc.apptrain.system.model.TrainMenu;
import com.epicc.apptrain.system.model.TrainUser;

import java.util.List;

public interface TrainUserService {

    public TrainUser findTrainUser(long id);
    public int modifyTrainUser(TrainUser trainUser);

    public TrainMenu findTrainMenu(long id);
    public int modifyTrainMenu(TrainMenu trainMenu);


}
