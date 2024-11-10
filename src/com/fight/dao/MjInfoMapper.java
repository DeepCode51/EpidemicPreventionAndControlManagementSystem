package com.fight.dao;

import com.fight.model.MjInfo;
import com.fight.model.MjInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface MjInfoMapper {
    long countByExample(MjInfoExample example);

    int deleteByExample(MjInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MjInfo record);

    int insertSelective(MjInfo record);

    List<MjInfo> selectByExample(MjInfoExample example);

    MjInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    MjInfo record, @Param("example")
    MjInfoExample example);

    int updateByExample(@Param("record")
    MjInfo record, @Param("example")
    MjInfoExample example);

    int updateByPrimaryKeySelective(MjInfo record);

    int updateByPrimaryKey(MjInfo record);
}

