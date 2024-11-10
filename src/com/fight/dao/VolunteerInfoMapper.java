package com.fight.dao;

import com.fight.model.VolunteerInfo;
import com.fight.model.VolunteerInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface VolunteerInfoMapper {
    long countByExample(VolunteerInfoExample example);

    int deleteByExample(VolunteerInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VolunteerInfo record);

    int insertSelective(VolunteerInfo record);

    List<VolunteerInfo> selectByExample(VolunteerInfoExample example);

    VolunteerInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    VolunteerInfo record, @Param("example")
    VolunteerInfoExample example);

    int updateByExample(@Param("record")
    VolunteerInfo record, @Param("example")
    VolunteerInfoExample example);

    int updateByPrimaryKeySelective(VolunteerInfo record);

    int updateByPrimaryKey(VolunteerInfo record);
}

