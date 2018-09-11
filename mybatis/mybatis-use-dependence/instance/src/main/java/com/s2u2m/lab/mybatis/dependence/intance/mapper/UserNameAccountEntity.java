package com.s2u2m.lab.mybatis.dependence.intance.mapper;

import java.time.Instant;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * class UserNameAccountEntity
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Getter
@Setter
@Accessors(chain = true)
public class UserNameAccountEntity {
    private String userName;
    private String password;
    private String userId;
    private Date createTime = Date.from(Instant.now());
}
