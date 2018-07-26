package com.s2u2m.javaresearch.spring.redisBasic.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2u2m.javaresearch.spring.redisBasic.demo.dao.ContactDAO;

/**
 * ContactService
 * Create by Yangyang.xia on 7/26/18
 */
@Service
public class ContactService {

    @Autowired
    private ContactDAO contactDAO;

    public List<String> getContactByPrefix(String prefix) {
        return contactDAO.getContactByPrefix(prefix);
    }

    public void addContact(String name) {
        contactDAO.addRecentContact(name);
    }
}
