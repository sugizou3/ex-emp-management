package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理者関連機能の業務処理を行うサービス.
 */

@Service
@Transactional

public class AdministratorService {
    /**
     * AdministratorRepositoryを参照
     */
    @Autowired
    AdministratorRepository repository;

    public void insert(Administrator administrator) {
        repository.insert(administrator);
    }

    /**
     * ログインをする業務処理を行うメソッド.
     *
     * @param mailAddress 管理者のメールアドレス
     * @param password    管理者のパスワード
     * @return Administrator メールとパスワードに一致する管理者のJavaクラスを返す。
     */
    public Administrator login(String mailAddress, String password) {
        return repository.findByMailAddressAndPassword(mailAddress, password);
    }

}
