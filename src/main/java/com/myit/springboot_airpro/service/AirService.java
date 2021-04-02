package com.myit.springboot_airpro.service;

import com.myit.springboot_airpro.pojo.Air;

import java.util.List;

public interface AirService {
    public List<Air>  selectAll();
    public List<Air>  selectList(String district);
    public int addAir(Air air);
}
