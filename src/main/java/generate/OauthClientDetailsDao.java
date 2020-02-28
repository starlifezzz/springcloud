package generate;

import generate.OauthClientDetails;
import generate.OauthClientDetailsExample;
import generate.OauthClientDetailsWithBLOBs;
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