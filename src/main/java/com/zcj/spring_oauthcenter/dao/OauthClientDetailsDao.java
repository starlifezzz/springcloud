package com.zcj.spring_oauthcenter.dao;

import com.zcj.spring_oauthcenter.po.OauthClientDetails;
import com.zcj.spring_oauthcenter.po.OauthClientDetailsExample;
import com.zcj.spring_oauthcenter.po.OauthClientDetailsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthClientDetailsDao {
    long countByExample(OauthClientDetailsExample example);

    int deleteByExample(OauthClientDetailsExample example);

    int insert(OauthClientDetailsWithBLOBs record);

    int insertSelective(OauthClientDetailsWithBLOBs record);

    List<OauthClientDetailsWithBLOBs> selectByExampleWithBLOBs(OauthClientDetailsExample example);

    List<OauthClientDetails> selectByExample(OauthClientDetailsExample example);

    int updateByExampleSelective(@Param("record") OauthClientDetailsWithBLOBs record, @Param("example") OauthClientDetailsExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthClientDetailsWithBLOBs record, @Param("example") OauthClientDetailsExample example);

    int updateByExample(@Param("record") OauthClientDetails record, @Param("example") OauthClientDetailsExample example);
}