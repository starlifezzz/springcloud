package generate;

import generate.TbUserRole;
import generate.TbUserRoleExample;
import generate.TbUserRoleWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserRoleDao {
    long countByExample(TbUserRoleExample example);

    int deleteByExample(TbUserRoleExample example);

    int insert(TbUserRoleWithBLOBs record);

    int insertSelective(TbUserRoleWithBLOBs record);

    List<TbUserRoleWithBLOBs> selectByExampleWithBLOBs(TbUserRoleExample example);

    List<TbUserRole> selectByExample(TbUserRoleExample example);

    int updateByExampleSelective(@Param("record") TbUserRoleWithBLOBs record, @Param("example") TbUserRoleExample example);

    int updateByExampleWithBLOBs(@Param("record") TbUserRoleWithBLOBs record, @Param("example") TbUserRoleExample example);

    int updateByExample(@Param("record") TbUserRole record, @Param("example") TbUserRoleExample example);
}