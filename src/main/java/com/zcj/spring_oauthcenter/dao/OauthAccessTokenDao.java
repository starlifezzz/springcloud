package com.zcj.spring_oauthcenter.dao;

import com.zcj.spring_oauthcenter.po.OauthAccessToken;
import com.zcj.spring_oauthcenter.po.OauthAccessTokenExample;
import com.zcj.spring_oauthcenter.po.OauthAccessTokenWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthAccessTokenDao {
    long countByExample(OauthAccessTokenExample example);

    int deleteByExample(OauthAccessTokenExample example);

    int insert(OauthAccessTokenWithBLOBs record);

    int insertSelective(OauthAccessTokenWithBLOBs record);

    List<OauthAccessTokenWithBLOBs> selectByExampleWithBLOBs(OauthAccessTokenExample example);

    List<OauthAccessToken> selectByExample(OauthAccessTokenExample example);

    int updateByExampleSelective(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthAccessTokenWithBLOBs record, @Param("example") OauthAccessTokenExample example);

    int updateByExample(@Param("record") OauthAccessToken record, @Param("example") OauthAccessTokenExample example);
}