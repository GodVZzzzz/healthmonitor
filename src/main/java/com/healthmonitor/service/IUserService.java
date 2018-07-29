package com.healthmonitor.service;

import com.healthmonitor.common.ServerResponse;
import com.healthmonitor.pojo.user;

public interface IUserService {

    ServerResponse<user> login(String account, String password);

    ServerResponse<String> register(user user);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse selectQuestion(String account);

    ServerResponse<String> checkAnswer(String account,String question,String answer);

    ServerResponse<String> forgetResetPassword(String account,String passwordNew,String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,Integer id);

    ServerResponse<user> updateInformation(user user1);

    ServerResponse<user> getInfo(Integer id);

    ServerResponse<user> logout(user user1);

}
