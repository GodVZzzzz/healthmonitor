package com.healthmonitor.dao;

import com.healthmonitor.pojo.user;
import org.apache.ibatis.annotations.Param;

public interface userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

    int checkUserAccount(String account);

    user selectLogin(@Param("account") String account, @Param("password") String password);

    int checkEmail(String str);

    String selectQuestionByAccount(String account);

    int checkAnswer(@Param("account") String account, @Param("question") String question, @Param("answer") String answer);

    int updatePasswordByAccount(@Param("account") String account, @Param("passwordNew") String passwordNew);

    int checkPassword(@Param("password") String passwordOld, @Param("id") Integer id);
}