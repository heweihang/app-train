package com.epicc.apptrain.system.dao;

import com.epicc.apptrain.system.model.TrainMenu;
import com.epicc.apptrain.system.model.TrainUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainUserMapper {

    /*@Select("select * from train_user")
    @Results({
            @Result(property = "`userId`",column = "USER_ID"),
            @Result(property = "`userName",column = "USER_NAME"),
            @Result(property = "`userPassword`",column = "USER_PASSWORD"),
            @Result(property = "`regisierTime`",column = "REGISTER_TIME")
    })
    List<TrainUser> getAll();



    @Select("SELECT * FROM `train_user` WHERE USER_ID = #{userId}")
    @Results({
            @Result(property = "`userId`",column = "USER_ID"),
            @Result(property = "`userName",column = "USER_NAME"),
            @Result(property = "`userPassword`",column = "USER_PASSWORD"),
            @Result(property = "`regisierTime`",column = "REGISTER_TIME")
    })
    TrainUser findAddressById(Long id);*/

    TrainUser findTrainUserById(Long id);

    int  modifyTrainUser( TrainUser trainUser);



    TrainMenu findTrainMenuById(Long id);

    int  modifyTrainMenu( TrainMenu trainMenu);

}
