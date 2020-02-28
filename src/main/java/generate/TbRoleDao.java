package generate;

import generate.TbRole;
import generate.TbRoleExample;
import generate.TbRoleWithBLOBs;
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