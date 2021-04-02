package com.myit.springboot_airpro.dao;

import com.myit.springboot_airpro.pojo.Air;

import java.util.List;

@Mapper
public interface AirMapper {
    @Select("select  *  from  air_quality_index  order by monitorTime desc")
    public List<Air>  selectAir();
    @Select("select  *  from  air_quality_index where district=#{district}  order by monitorTime desc")
    public List<Air> selectList(@Param("district")String  district);
    @Insert("insert into  air_quality_index(district,monitorTime,pm10,pm25,monitoringStation) values(#{district},#{monitorTime},#{pm10},#{pm25},#{monitoringStation})")
    public int addAir(Air air);
}
