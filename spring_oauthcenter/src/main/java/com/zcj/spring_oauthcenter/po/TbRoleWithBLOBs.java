package com.zcj.spring_oauthcenter.po;

import java.io.Serializable;
import lombok.Data;

/**
 * oauth_access_token
 * @author 
 */
@Data
public class TbRoleWithBLOBs extends TbRole implements Serializable {
    private byte[] token;

    private byte[] authentication;

    private static final long serialVersionUID = 1L;
}