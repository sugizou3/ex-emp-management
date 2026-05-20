package com.example.domain;

import lombok.*;

/**
 * 管理者情報を表すドメイン.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Administrator {
    /**
     * 主キー
     */
    private Integer id;
    /**
     * 管理者名
     */
    private String name;
    /**
     * メールアドレス
     */
    private String mailAddress;
    /**
     * パスワード
     */
    private String password;

}
