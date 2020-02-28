package com.zcj.spring_oauthcenter.dao;

import com.zcj.spring_oauthcenter.po.TbRole;
import com.zcj.spring_oauthcenter.po.TbRoleExample;
import com.zcj.spring_oauthcenter.po.TbRoleWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbRoleDao {
    long countByExample(TbRoleExample example);

    int deleteByExample(TbRoleExample example);

    int insert(TbRoleWithBLOBs record);

    int insertSelective(TbRoleWithBLOBs record);

    List<TbRoleWithBLOBs> selectByExampleWithBLOBs(TbRoleExample example);

    List<TbRole> selectByExample(TbRoleExample example);

    int updateByExampleSelective(@Param("record") TbRoleWithBLOBs record, @Param("example") TbRoleExample example);

    int updateByExampleWithBLOBs(@Param("record") TbRoleWithBLOBs record, @Param("example") TbRoleExample example);

    int updateByExample(@Param("record") TbRole record, @Param("example") TbRoleExample example);
}