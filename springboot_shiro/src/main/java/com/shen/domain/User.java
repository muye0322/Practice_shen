package com.shen.domain;

import lombok.Data;

/**
 * 用户实体
 * @author shen
 */
@Data
public class User {
    private String id;
    private String username;
    private String pwd;
    /**
     * 权限标识
     */
    private String perms;
}
