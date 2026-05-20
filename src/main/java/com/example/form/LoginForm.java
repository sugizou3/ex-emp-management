package com.example.form;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoginForm {
    /**
     * メールアドレス
     */
    private String mailAddress;

    /**
     * パスワード
     */
    private String password;
    
}
