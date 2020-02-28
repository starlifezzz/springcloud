package generator;

import java.io.Serializable;
import lombok.Data;

/**
 * oauth_access_token
 * @author 
 */
@Data
public class TbUserRole implements Serializable {
    private String tokenId;

    private String authenticationId;

    private String userName;

    private String clientId;

    private String refreshToken;

    private static final long serialVersionUID = 1L;
}