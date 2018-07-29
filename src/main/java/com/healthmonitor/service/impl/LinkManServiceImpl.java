package com.healthmonitor.service.impl;

import com.healthmonitor.common.ServerResponse;
import com.healthmonitor.dao.linkmanMapper;
import com.healthmonitor.dao.userMapper;
import com.healthmonitor.pojo.linkman;
import com.healthmonitor.pojo.user;
import com.healthmonitor.service.ILinkManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("iLinkManService")
public class LinkManServiceImpl implements ILinkManService{

    @Autowired
    private linkmanMapper linkmanMapper;

    @Override
    public ServerResponse<List<linkman>> searchLinkMan (String account){
        List<linkman> linkmanInfo = linkmanMapper.selectByAccount(account);
        if(linkmanInfo.isEmpty())
            return ServerResponse.createByErrorMessage("未添加联系人");

        return ServerResponse.createBySuccess("查询成功",linkmanInfo);


     }

    public ServerResponse<linkman> insertLinkMan(linkman linkman1){
        int resultCount = linkmanMapper.insert(linkman1);
        if(resultCount == 0){
            return ServerResponse.createByErrorMessage("添加失败");
        }
        return ServerResponse.createBySuccess("添加成功",linkman1);
    }

    public ServerResponse<linkman> updateLinkMan(linkman linkman1){
        linkman updateLinkMan = new linkman();
        updateLinkMan.setId(linkman1.getId());
        updateLinkMan.setUserAccount(linkman1.getUserAccount());
        updateLinkMan.setEmail(linkman1.getEmail());
        updateLinkMan.setName(linkman1.getName());
        updateLinkMan.setTel(linkman1.getTel());
        updateLinkMan.setEmail(linkman1.getEmail());

        int resultCount = linkmanMapper.updateByPrimaryKeySelective(updateLinkMan);

        if(resultCount > 0){
            return ServerResponse.createBySuccess("更新联系人信息成功",updateLinkMan);
        }

        return ServerResponse.createByErrorMessage("更新联系人信息失败");
    }

    public ServerResponse<String> deleteLinkMan(Integer id){
        int resultCount = linkmanMapper.deleteByPrimaryKey(id);
        if(resultCount == 0){
            ServerResponse.createByErrorMessage("删除失败");
        }

        return ServerResponse.createBySuccessMessage("删除成功");
    }
}
