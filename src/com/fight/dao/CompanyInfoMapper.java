package com.fight.dao;

import com.fight.model.CompanyInfo;
import com.fight.model.CompanyInfoExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CompanyInfoMapper {
    long countByExample(CompanyInfoExample example);

    int deleteByExample(CompanyInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    List<CompanyInfo> selectByExample(CompanyInfoExample example);

    CompanyInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record")
    CompanyInfo record, @Param("example")
    CompanyInfoExample example);

    int updateByExample(@Param("record")
    CompanyInfo record, @Param("example")
    CompanyInfoExample example);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}

