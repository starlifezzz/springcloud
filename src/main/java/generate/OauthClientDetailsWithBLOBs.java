package generate;

import java.io.Serializable;
import lombok.Data;

/**
 * oauth_access_token
 * @author 
 */
@Data
public class OauthClientDetailsWithBLOBs extends OauthClientDetails implements Serializable {
    private byte[] token;

    private byte[] authentication;

    private static final long serialVersionUID = 1L;
}