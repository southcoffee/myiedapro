package com.myit.springboot_airpro.service.impl;

import com.myit.springboot_airpro.dao.AirMapper;
import com.myit.springboot_airpro.pojo.Air;
import com.myit.springboot_airpro.service.AirService;

import java.util.List;

@Service
public class AirServiceImpl  implements AirService {
    @AutoWired
    AirMapper  airMapper;
    public List<Air> selectAll(){
        return  airMapper.selectAir();
    }
    public List<Air>  selectList(String district){
        return airMapper.selectList(district);
    }
    public int addAir(Air air){
        return airMapper.addAir(air);
    }
}
