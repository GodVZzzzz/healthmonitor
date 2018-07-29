package com.healthmonitor.dao;

import com.healthmonitor.pojo.linkman;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface linkmanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(linkman record);

    int insertSelective(linkman record);

    linkman selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(linkman record);

    int updateByPrimaryKey(linkman record);

    List<linkman> selectByAccount(String account);
}