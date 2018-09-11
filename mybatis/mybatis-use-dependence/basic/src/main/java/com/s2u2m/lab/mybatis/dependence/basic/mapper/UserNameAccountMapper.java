package com.s2u2m.lab.mybatis.dependence.basic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * interface UserNameAccountMapper
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@Mapper
public interface UserNameAccountMapper {

    @Select("select userId, userName, password, createTime\n" +
            "from username_account\n" +
            "where userName=#{userName}\n"
    )
    UserNameAccountEntity getByUserName(String userName);

    int insert(UserNameAccountEntity entity);
}
