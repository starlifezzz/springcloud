package com.zcj.spring_oauthcenter.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * tb_user
 * @author 
 */
@Data
public class TbUser implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别（1男 2女）
     */
    private Integer gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除（1删除0未删除）
     */
    private Integer removed;

    private static final long serialVersionUID = 1L;
}