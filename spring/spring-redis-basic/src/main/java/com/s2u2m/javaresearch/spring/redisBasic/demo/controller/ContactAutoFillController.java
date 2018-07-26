package com.s2u2m.javaresearch.spring.redisBasic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.s2u2m.javaresearch.spring.redisBasic.demo.service.ContactService;

/**
 * ContactAutoFillController
 * Create by Yangyang.xia on 7/26/18
 */
@RestController
@RequestMapping(value = "/contact")
public class ContactAutoFillController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/recent")
    public List<String> getLatest(@RequestParam("prefix") String prefix) {
        return contactService.getContactByPrefix(prefix);
    }

    @PostMapping("/recent")
    public void addRecent(@RequestParam("user") String recentUser) {
        contactService.addContact(recentUser);
    }
}
