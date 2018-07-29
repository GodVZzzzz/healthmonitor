package com.healthmonitor.service;

import com.healthmonitor.common.ServerResponse;
import com.healthmonitor.pojo.linkman;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface ILinkManService {

    ServerResponse<List<linkman>> searchLinkMan (String account);

    ServerResponse<linkman> insertLinkMan(linkman linkman1);

    ServerResponse<linkman> updateLinkMan(linkman linkman1);

    ServerResponse<String> deleteLinkMan(Integer id);
}
