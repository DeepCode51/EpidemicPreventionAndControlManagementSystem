package com.fight.dao;

import com.fight.model.NoticeInfo;
import com.fight.model.NoticeInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface NoticeInfoMapper {
    long countByExample(NoticeInfoExample example);

    int deleteByExample(NoticeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeInfo record);

    int insertSelective(NoticeInfo record);

    List<NoticeInfo> selectByExample(NoticeInfoExample example);

    NoticeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    NoticeInfo record, @Param("example")
    NoticeInfoExample example);

    int updateByExample(@Param("record")
    NoticeInfo record, @Param("example")
    NoticeInfoExample example);

    int updateByPrimaryKeySelective(NoticeInfo record);

    int updateByPrimaryKey(NoticeInfo record);
}

