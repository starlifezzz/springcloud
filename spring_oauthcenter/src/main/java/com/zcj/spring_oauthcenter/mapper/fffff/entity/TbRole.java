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
public class TbRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 父类ID
     */
    private Long parentId;

    /**
     * 角色名字
     */
    private String name;

    /**
     * 角色名字
     */
    private String ename;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
