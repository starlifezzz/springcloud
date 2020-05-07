package com.zcj.spring_oauthcenter.mapper.fffff.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除（1删除0未删除）
     */
    private Integer removed;


}
