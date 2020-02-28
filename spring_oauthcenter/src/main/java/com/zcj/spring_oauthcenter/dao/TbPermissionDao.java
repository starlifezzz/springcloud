package com.zcj.spring_oauthcenter.dao;

import com.zcj.spring_oauthcenter.po.TbPermission;
import com.zcj.spring_oauthcenter.po.TbPermissionExample;
import com.zcj.spring_oauthcenter.po.TbPermissionWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbPermissionDao {
    long countByExample(TbPermissionExample example);

    int deleteByExample(TbPermissionExample example);

    int insert(TbPermissionWithBLOBs record);

    int insertSelective(TbPermissionWithBLOBs record);

    List<TbPermissionWithBLOBs> selectByExampleWithBLOBs(TbPermissionExample example);

    List<TbPermission> selectByExample(TbPermissionExample example);

    int updateByExampleSelective(@Param("record") TbPermissionWithBLOBs record, @Param("example") TbPermissionExample example);

    int updateByExampleWithBLOBs(@Param("record") TbPermissionWithBLOBs record, @Param("example") TbPermissionExample example);

    int updateByExample(@Param("record") TbPermission record, @Param("example") TbPermissionExample example);

    List<Map> queryByUserid(@Param("userId") int userId);
}
