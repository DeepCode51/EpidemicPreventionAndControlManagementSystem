package com.fight.dao;

import com.fight.model.ActInfo;
import com.fight.model.ActInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ActInfoMapper {
    long countByExample(ActInfoExample example);

    int deleteByExample(ActInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActInfo record);

    int insertSelective(ActInfo record);

    List<ActInfo> selectByExample(ActInfoExample example);

    ActInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    ActInfo record, @Param("example")
    ActInfoExample example);

    int updateByExample(@Param("record")
    ActInfo record, @Param("example")
    ActInfoExample example);

    int updateByPrimaryKeySelective(ActInfo record);

    int updateByPrimaryKey(ActInfo record);
}

