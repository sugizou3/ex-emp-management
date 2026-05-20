package com.example.controller;

import com.example.form.InsertAdministratorForm;
import com.example.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")


public class AdministratorController {
    @Autowired
    AdministratorService service;

    @GetMapping("/to-insert")
    public String toInsert(InsertAdministratorForm form) {
        System.out.println("gowegjewoijgweoigj");
        return "administrator/insert";
    }


}
