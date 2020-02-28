package com.zcj.spring_oauthcenter.dao;

import com.zcj.spring_oauthcenter.po.OauthRefreshToken;
import com.zcj.spring_oauthcenter.po.OauthRefreshTokenExample;
import com.zcj.spring_oauthcenter.po.OauthRefreshTokenWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthRefreshTokenDao {
    long countByExample(OauthRefreshTokenExample example);

    int deleteByExample(OauthRefreshTokenExample example);

    int insert(OauthRefreshTokenWithBLOBs record);

    int insertSelective(OauthRefreshTokenWithBLOBs record);

    List<OauthRefreshTokenWithBLOBs> selectByExampleWithBLOBs(OauthRefreshTokenExample example);

    List<OauthRefreshToken> selectByExample(OauthRefreshTokenExample example);

    int updateByExampleSelective(@Param("record") OauthRefreshTokenWithBLOBs record, @Param("example") OauthRefreshTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthRefreshTokenWithBLOBs record, @Param("example") OauthRefreshTokenExample example);

    int updateByExample(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenExample example);
}