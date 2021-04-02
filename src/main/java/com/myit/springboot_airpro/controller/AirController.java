package com.myit.springboot_airpro.controller;

import com.myit.springboot_airpro.pojo.Air;
import com.myit.springboot_airpro.service.AirService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AirController {
     @Resource
      AirService  airService;
    @RequestMapping("/")
    public String  getIndex(Model model){
        model.addAttribute("title","我的空气质量监测系统");
        return  "index";
    }
    @RequestMapping("/airlist")
    @ResponseBody
    public List<Air>  getAir(Model model,@RequestParam(value="district",required=false)String district){
        List<Air> list=null;
       /* if(district!=""&&district!=null){
            //调用带条件查询

        }
        else{
            list=airService.selectAll();
        }*/
        list=airService.selectAll();
        return list;
    }
    //跳转到添加页面
    @RequestMapping("/addair")
    public String  addAir(Model  model){
       return "addairview";
    }
    //实现添加数据到数据库
    @RequestMapping("/saveair")
    @ResponseBody
    public  Object saveAir(Air air,@RequestParam(value="mTime",required=false)String mTime){
       String message="";
       int res=0;
        SimpleDateFormat  format=new SimpleDateFormat("yyyy-MM-dd");
      try{
          Date monitorTime=format.parse(mTime);
          Date  createTime=new Date();
          air.setMonitorTime(monitorTime);
          air.setCreateDate(createTime);
          res=airService.addAir (air);
      }catch (Exception ex){}
      if(res>0){
          message="添加成功";
      }else
          message="添加失败";
      return  message;
    }
}
