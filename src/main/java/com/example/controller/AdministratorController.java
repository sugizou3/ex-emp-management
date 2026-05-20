package com.example.controller;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")


public class AdministratorController {
    @Autowired
    AdministratorService service;

    /**
     * 管理者登録表示.
     *
     * @param form
     * @return String 管理者登録UI用htmlタグのパス
     */
    @GetMapping("/to-insert")
    public String toInsert(InsertAdministratorForm form) {
        System.out.println("gowegjewoijgweoigj");
        return "administrator/insert";
    }

    /**
     * 管理者登録のポスト処理.
     *
     * @param form
     * @return String ログイン画面へリダイレクト
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form, administrator);

        service.insert(administrator);
        System.out.println(administrator);
        return "redirect:/";
    }

    /**
     * ログイン画面のUI表示.
     *
     * @param form
     * @return String ログイン画面UIのhtmlへのパス
     */
    @GetMapping("/")
    public String toLogin(LoginForm form) {
        return "administrator/login";
    }


}
