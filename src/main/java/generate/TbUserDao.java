package generate;

import generate.TbUser;
import generate.TbUserExample;
import generate.TbUserWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserDao {
    long countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int insert(TbUserWithBLOBs record);

    int insertSelective(TbUserWithBLOBs record);

    List<TbUserWithBLOBs> selectByExampleWithBLOBs(TbUserExample example);

    List<TbUser> selectByExample(TbUserExample example);

    int updateByExampleSelective(@Param("record") TbUserWithBLOBs record, @Param("example") TbUserExample example);

    int updateByExampleWithBLOBs(@Param("record") TbUserWithBLOBs record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);
}