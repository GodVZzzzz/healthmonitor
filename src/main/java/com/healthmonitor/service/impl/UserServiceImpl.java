package com.healthmonitor.service.impl;

import com.healthmonitor.common.Const;
import com.healthmonitor.common.ServerResponse;
import com.healthmonitor.common.TokenCache;
import com.healthmonitor.pojo.user;
import com.healthmonitor.dao.userMapper;
import com.healthmonitor.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service("iUserService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private userMapper userMapper;

    @Override
    public ServerResponse<user> login(String account, String password){

        int resultCount = userMapper.checkUserAccount(account);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        user user = userMapper.selectLogin(account,password);
        if(user == null){
            return ServerResponse.createByErrorMessage("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess("登录成功",user);

    }

    public ServerResponse<String> register(user user){

        int resultCount = userMapper.checkUserAccount(user.getAccount());
        if(resultCount > 0){
            return ServerResponse.createByErrorMessage("用户名已存在");

        }
        else {
            int resultCount1 = userMapper.insert(user);
            if (resultCount1 == 0)
                return ServerResponse.createByErrorMessage("注册失败");
        }


        return ServerResponse.createBySuccessMessage("注册成功");

    }

    public ServerResponse<String> checkValid(String str,String type) {

        if (StringUtils.isNotBlank(type)) {
            if (Const.ACCOUNT.equals(type)) {
                int resultCount = userMapper.checkUserAccount(str);
                if (resultCount > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }

        } else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccess("校验成功");
    }

    public ServerResponse selectQuestion(String account){
        ServerResponse validResponse = this.checkValid(account,Const.ACCOUNT);
        if(validResponse.isSuccess()){
            return ServerResponse.createByErrorMessage("用户不存在");
        }
        String question = userMapper.selectQuestionByAccount(account);
        if(StringUtils.isNotBlank(question)){
            return ServerResponse.createBySuccess(question);
        }

        return ServerResponse.createByErrorMessage("找回密码的问题是空的");
    }

    public ServerResponse<String> checkAnswer(String account,String question,String answer){
        int resultCount = userMapper.checkAnswer(account,question,answer);
        if(resultCount > 0 ){
            String forgetToken = UUID.randomUUID().toString();
            TokenCache.setKey(TokenCache.TOKEN_PREFIX+account,forgetToken);
            return ServerResponse.createBySuccess(forgetToken);
        }
        return ServerResponse.createByErrorMessage("问题的答案错误");
    }

    public ServerResponse<String> forgetResetPassword(String account,String passwordNew, String forgetToken){
        if(StringUtils.isBlank(forgetToken)){
            return ServerResponse.createByErrorMessage("参数错误，token需要传递");
        }
        ServerResponse validResponse = this.checkValid(account,Const.ACCOUNT);
        if(validResponse.isSuccess()){
            return ServerResponse.createByErrorMessage("用户不存在");
        }

        String token = TokenCache.getKey(TokenCache.TOKEN_PREFIX+account);
        if(StringUtils.isBlank(token)){
            return ServerResponse.createByErrorMessage("token无效或者过期");
        }

        if(StringUtils.equals(forgetToken,token)){
            int rowCount = userMapper.updatePasswordByAccount(account,passwordNew);

            if(rowCount > 0){
                return ServerResponse.createBySuccessMessage("修改密码成功");
            }
        }
        else{
            return ServerResponse.createByErrorMessage("token错误，请重新获取重置密码的token");
        }
        return ServerResponse.createByErrorMessage("修改密码失败");
    }

    public ServerResponse<String> resetPassword(String passwordOld,String passwordNew,Integer id){
        int resultCount = userMapper.checkPassword(passwordOld,id);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("旧密码错误");
        }

        user user1 = new user();
        user1.setId(id);
        user1.setPassword(passwordNew);
        int updateCount = userMapper.updateByPrimaryKeySelective(user1);
        if(updateCount > 0){
            return ServerResponse.createBySuccessMessage("密码更新成功");
        }

        return ServerResponse.createByErrorMessage("密码更新失败");
    }

    public ServerResponse<user> updateInformation(user user1){

        user updateUser = new user();
        updateUser.setId(user1.getId());
        updateUser.setAge(user1.getAge());
        updateUser.setEmail(user1.getEmail());
        updateUser.setHeight(user1.getHeight());
        updateUser.setName(user1.getName());
        updateUser.setSex(user1.getSex());
        updateUser.setTel(user1.getTel());
        updateUser.setWeight(user1.getWeight());
        updateUser.setAccount(user1.getAccount());
        updateUser.setHeartrate(user1.getHeartrate());
        updateUser.setBloodpressure(user1.getBloodpressure());
        updateUser.setStep(user1.getStep());
        updateUser.setSleep(user1.getSleep());
        updateUser.setImageid(user1.getImageid());

        int updateCount = userMapper.updateByPrimaryKeySelective(updateUser);

        if(updateCount > 0){
            return ServerResponse.createBySuccess("更新个人信息成功",updateUser);
        }

        return ServerResponse.createByErrorMessage("更新个人信息失败");
    }

    public ServerResponse<user> getInfo(Integer id){
        user user1 = userMapper.selectByPrimaryKey(id);
        if(user1 == null){
            return ServerResponse.createByErrorMessage("找不到当前用户");
        }
        user1.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccess(user1);
    }

    public ServerResponse<user> logout(user user1){
        if(user1 == null){
            return ServerResponse.createByErrorMessage("当前未登录");
        }
        return ServerResponse.createBySuccess("注销成功",null);
    }

}
