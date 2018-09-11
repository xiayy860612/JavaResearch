package com.s2u2m.lab.mybatis.dependence.intance.mapper;

import java.util.List;

/**
 * interface UserNameAccountMapper
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
public interface UserNameAccountMapper {

    UserNameAccountEntity getByUserName(String userName);

    int insert(UserNameAccountEntity entity);
}
