package com.healthmonitor.controller;

import com.healthmonitor.common.ServerResponse;
import com.healthmonitor.pojo.linkman;
import com.healthmonitor.service.ILinkManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/linkman/")
public class LinkManController {

    @Autowired
    private ILinkManService iLinkManService;

    @RequestMapping(value = "insert_linkman.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<linkman> insertMan(linkman linkman1){
        return iLinkManService.insertLinkMan(linkman1);
    }

    @RequestMapping(value = "update_info.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<linkman> updateInfo(linkman linkman1){
        return iLinkManService.updateLinkMan(linkman1);
    }

    @RequestMapping(value = "delete_man.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> deleteMan(Integer id){
        return iLinkManService.deleteLinkMan(id);
    }

    @RequestMapping(value = "search_man.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<linkman>> searchLinkMan (String user_account){
        return iLinkManService.searchLinkMan(user_account);
    }
}
