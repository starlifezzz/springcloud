package generate;

import generate.OauthCode;
import generate.OauthCodeExample;
import generate.OauthCodeWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OauthCodeDao {
    long countByExample(OauthCodeExample example);

    int deleteByExample(OauthCodeExample example);

    int insert(OauthCodeWithBLOBs record);

    int insertSelective(OauthCodeWithBLOBs record);

    List<OauthCodeWithBLOBs> selectByExampleWithBLOBs(OauthCodeExample example);

    List<OauthCode> selectByExample(OauthCodeExample example);

    int updateByExampleSelective(@Param("record") OauthCodeWithBLOBs record, @Param("example") OauthCodeExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthCodeWithBLOBs record, @Param("example") OauthCodeExample example);

    int updateByExample(@Param("record") OauthCode record, @Param("example") OauthCodeExample example);
}