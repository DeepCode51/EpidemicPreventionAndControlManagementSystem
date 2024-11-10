package com.fight.dao;

import com.fight.model.HospitalNeedInfo;
import com.fight.model.HospitalNeedInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HospitalNeedInfoMapper {
    long countByExample(HospitalNeedInfoExample example);

    int deleteByExample(HospitalNeedInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HospitalNeedInfo record);

    int insertSelective(HospitalNeedInfo record);

    List<HospitalNeedInfo> selectByExample(HospitalNeedInfoExample example);

    HospitalNeedInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    HospitalNeedInfo record, @Param("example")
    HospitalNeedInfoExample example);

    int updateByExample(@Param("record")
    HospitalNeedInfo record, @Param("example")
    HospitalNeedInfoExample example);

    int updateByPrimaryKeySelective(HospitalNeedInfo record);

    int updateByPrimaryKey(HospitalNeedInfo record);
}

