package com.s2u2m.lab.mybatis.dependence.intance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2u2m.lab.mybatis.dependence.basic.mapper.UserNameAccountEntity;
import com.s2u2m.lab.mybatis.dependence.basic.mapper.UserNameAccountMapper;

/**
 * AccountController
 * Create by Yangyang.xia on 9/11/18
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private UserNameAccountMapper mapper;


    @PostMapping("/create")
    public ResponseEntity<Boolean> create(@RequestBody UserNameAccountEntity input) {
        mapper.insert(input);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserNameAccountEntity> get(@PathVariable String username) {
        UserNameAccountEntity entity = mapper.getByUserName(username);
        return ResponseEntity.ok(entity);
    }
}
