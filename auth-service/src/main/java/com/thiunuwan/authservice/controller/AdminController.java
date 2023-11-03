package com.thiunuwan.authservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AdminController {

    @GetMapping("/admin/")
    public String helloAdminController(){

        return  "admin access level";
    }
}
