package com.fight.dao;

import com.fight.model.HospitalInfo;
import com.fight.model.HospitalInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HospitalInfoMapper {
    long countByExample(HospitalInfoExample example);

    int deleteByExample(HospitalInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HospitalInfo record);

    int insertSelective(HospitalInfo record);

    List<HospitalInfo> selectByExample(HospitalInfoExample example);

    HospitalInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    HospitalInfo record, @Param("example")
    HospitalInfoExample example);

    int updateByExample(@Param("record")
    HospitalInfo record, @Param("example")
    HospitalInfoExample example);

    int updateByPrimaryKeySelective(HospitalInfo record);

    int updateByPrimaryKey(HospitalInfo record);
}

