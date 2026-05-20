package com.example.controller;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理者関連機能の処理の制御を行うコントローラー.
 */
@Controller
@RequestMapping("/")
public class AdministratorController {
    @Autowired
    AdministratorService service;
    @Autowired
    private HttpSession session;

    /**
     * 管理者登録画面を表示.
     *
     * @param form フォーム
     * @return String 管理者登録画面
     */
    @GetMapping("/to-insert")
    public String toInsert(InsertAdministratorForm form) {
        return "administrator/insert";
    }

    /**
     * 管理者登録のポスト処理.
     *
     * @param form フォーム
     * @return String ログイン画面
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
     * @param form フォーム
     * @return String ログイン画面
     */
    @GetMapping("/")
    public String toLogin(LoginForm form) {
        return "administrator/login";
    }

    /**
     * ログイン処理を行う.
     *
     * @param form  フォーム
     * @param model モデル
     * @return ログイン失敗→ログイン画面<br>
     * 　　　　　ログイン成功→従業員一覧画面
     */
    @PostMapping("/login")
    public String login(LoginForm form, Model model) {
        Administrator administrator
                = service.login(form.getMailAddress(), form.getPassword());

        System.out.println(administrator);
        if (administrator == null) {
            model.addAttribute("errorMessage", "メールアドレス、またはパスワードが間違っています。");
            return "administrator/login";
        }
        session.setAttribute("administratorName", administrator.getName());
        return "redirect:/employee/show-list";
    }


}
