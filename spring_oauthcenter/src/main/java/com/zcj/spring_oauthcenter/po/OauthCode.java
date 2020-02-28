package com.zcj.spring_oauthcenter.po;

import java.io.Serializable;
import lombok.Data;

/**
 * oauth_code
 * @author 
 */
@Data
public class OauthCode implements Serializable {
    private String code;

    private byte[] authentication;

    private static final long serialVersionUID = 1L;
}