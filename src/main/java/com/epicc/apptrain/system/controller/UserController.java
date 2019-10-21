package com.epicc.apptrain.system.controller;

import com.epicc.apptrain.system.model.TrainMenu;
import com.epicc.apptrain.system.model.TrainUser;
import com.epicc.apptrain.system.service.TrainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Title:UserController
 * @Description;ToDo
 * @Author: wangpan
 * @Date 2019/10/18 0018 上午 8:58
 * @Version: 1.0
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TrainUserService trainUserService;

    @Value("${videoPathUrl}")
    private String videoPathUrl;

    @Value("${imagePathUrl}")
    private String imagePathUrl;

    @RequestMapping("/index")
    @ResponseBody
    public ModelAndView findTrainUser(){
        int userId=1;
        int menuId=1;
        long user_id = Long.parseLong(userId +"");
        long menu_id = Long.parseLong(menuId + "");
        TrainUser trainUser = trainUserService.findTrainUser(user_id);
        TrainMenu trainMenu = trainUserService.findTrainMenu(menu_id);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("trainUser",trainUser);
        modelAndView.addObject("trainMenu",trainMenu);
        return  modelAndView;
    }


    @GetMapping("/trainMenu")
    @ResponseBody
    public String findTrainMenu(int menuId){
        long menu_id = Long.parseLong(menuId + "");
        TrainMenu trainMenu = trainUserService.findTrainMenu(menu_id);
        return  trainMenu.toString();
    }




    //修改账户密码
    @RequestMapping("/modifyTrainUser")
    @ResponseBody
    public ModelAndView modifyTrainUser(TrainUser trainUser){
        trainUser.setUserId(1);
        trainUser.setUserName("admin1");
        trainUser.setUserPassword("654321");
        int i = trainUserService.modifyTrainUser(trainUser);
        ModelAndView modelAndView = new ModelAndView("index1");
        modelAndView.addObject("modify_value",i);
        return  modelAndView;
    }




    //修改账户密码
    @RequestMapping("/modifyTrainMenu")
    @ResponseBody
    public ModelAndView modifyTrainMenu(String trainNameUrl,String activityNameUrl,
                                        String honorNameUrl,String advisorySellNameUrl,
                                        String newBarrcksNameUrl,@RequestParam("file1") MultipartFile file1,
                                        @RequestParam("file2") MultipartFile file2,
                                        String type1,String type2
                                        ){

        TrainMenu trainMenu = trainUserService.findTrainMenu(1);
            trainMenu.setTrainNameUrl(trainNameUrl);
            trainMenu.setActivityNameUrl(activityNameUrl);
        trainMenu.setHonorNameUrl(honorNameUrl);
        trainMenu.setAdvisorySellNameUrl(advisorySellNameUrl);
        trainMenu.setNewBarrcksNameUrl(newBarrcksNameUrl);
        Date date = new Date();
        trainMenu.setCreateTime(date);



            //type=1 代表是图片，2代表是视频
            if (!file1.isEmpty()) {
                String fileName = file1.getOriginalFilename();
                String filePath ="";
                if(type1.equals("1")){
                    filePath = imagePathUrl;
                }else{
                    filePath = videoPathUrl;
                }
                File dest = new File(filePath + fileName);
                try {
                    file1.transferTo(dest);
                    trainMenu.setResourceOneUrl(filePath+fileName);
                    trainMenu.setResourceOneType(type1);
                } catch (IOException e) {

                }
            }
            if (!file2.isEmpty()) {
                String fileName = file2.getOriginalFilename();
                String filePath ="";
                if(type2.equals("1")){
                    filePath = imagePathUrl;
                }else{
                    filePath = videoPathUrl;
                }
                File dest = new File(filePath + fileName);
                try {
                    file2.transferTo(dest);
                    trainMenu.setResourceTwoUrl(filePath+fileName);
                    trainMenu.setResourceTwoType(type2);
                } catch (IOException e) {

                }
            }
        int i1 = trainUserService.modifyTrainMenu(trainMenu);
            long menu_id = Long.parseLong(1 + "");
            TrainMenu trainMenu_last = trainUserService.findTrainMenu(menu_id);
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("trainMenu",trainMenu_last);
        return  modelAndView;

    }

    @RequestMapping("/uploadResource")
    @ResponseBody
    public ModelAndView uploadResource(){
        ModelAndView modelAndView = new ModelAndView("uploadResource");
        return  modelAndView;
    }


    //上传文件
    @RequestMapping("/upload")
    @ResponseBody
    public ModelAndView upload(@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,String type1,String type2) {
        //type=1 代表是图片，2代表是视频
        System.out.println("类型"+type1);
        if (file1.isEmpty() && file2.isEmpty()) {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
        if (!file1.isEmpty()) {
            String fileName = file1.getOriginalFilename();
            String filePath ="";
            if(type1.equals("1")){
                filePath = imagePathUrl;
            }else{
                filePath = videoPathUrl;
            }
            File dest = new File(filePath + fileName);
            try {
                file1.transferTo(dest);
                TrainMenu trainMenu = trainUserService.findTrainMenu(1);
                trainMenu.setResourceOneUrl(filePath+fileName);
                trainMenu.setResourceOneType(type1);
                trainUserService.modifyTrainMenu(trainMenu);
            } catch (IOException e) {

            }
        }

        if (!file2.isEmpty()) {
            String fileName = file2.getOriginalFilename();
            String filePath ="";
            if(type2.equals("1")){
                filePath = imagePathUrl;
            }else{
                filePath = videoPathUrl;
            }
            File dest = new File(filePath + fileName);
            try {
                file2.transferTo(dest);
                TrainMenu trainMenu = trainUserService.findTrainMenu(1);
                trainMenu.setResourceTwoUrl(filePath+fileName);
                trainMenu.setResourceTwoType(type2);
                trainUserService.modifyTrainMenu(trainMenu);
            } catch (IOException e) {

            }
        }

        long menu_id = Long.parseLong(1 + "");
        TrainMenu trainMenu = trainUserService.findTrainMenu(menu_id);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("trainMenu",trainMenu);
        return modelAndView;
    }




    @RequestMapping("/validateName")
    @ResponseBody
    public ModelAndView validateName(){
        ModelAndView modelAndView = new ModelAndView("validateName");
        return  modelAndView;
    }



    @RequestMapping("/validate")
    @ResponseBody
    public String findTrainUserValidate(String userPassword){
        long user_id = Long.parseLong(1 +"");
        TrainUser trainUser = trainUserService.findTrainUser(user_id);
        if(trainUser != null && userPassword != null){
            if(userPassword.equals(trainUser.getUserPassword())){
                return "true";
            }else{
                return "false";
            }
        }
        return  "false";
    }

    @RequestMapping("/validateEdit")
    @ResponseBody
    public ModelAndView validateEdit(String menu_id){
        ModelAndView modelAndView = null;
        long menu_id_value = Long.parseLong(1 + "");
        TrainMenu trainMenu = trainUserService.findTrainMenu(menu_id_value);
        modelAndView = new ModelAndView("edit");
        modelAndView.addObject("trainMenu",trainMenu);
        return modelAndView;
    }



}
