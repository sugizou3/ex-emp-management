package com.example.repository;

import com.example.domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * administratorテーブルを操作するリポジトリ.
 */

@Repository

public class AdministratorRepository {
    RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Administrator.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    /**
     * 管理者情報を挿入する.
     *
     * @param administrator 管理者ドメイン
     */
    public void insert(Administrator administrator) {
        SqlParameterSource param
                = new BeanPropertySqlParameterSource(administrator);

        String sql = """
                INSERT INTO administrators(name,mail_address,password)
                VALUES (:name,:mailAddress,:password);
                """;


        template.update(sql, param);

    }

    /**
     * メールアドレスとパスワードから管理者情報を取得する
     * （1件も存在しない場合はnullを返す※）.
     *
     * @param mailAdress 管理者メールアドレス
     * @param password   管理者パスワード
     * @return Administrator 管理者ドメイン
     */
    public Administrator findByMailAddressAndPassword(String mailAdress, String password) {
        String sql = """
                SELECT id,name,mail_address,password
                FROM administrators
                WHERE mail_address = :mailAdress AND password=:password;
                """;
        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("mailAdress", mailAdress)
                .addValue("password", password);

        List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
        if (administratorList.isEmpty()) {
            return null;
        }
        return administratorList.getFirst();
    }


}
