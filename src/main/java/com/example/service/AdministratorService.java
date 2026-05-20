package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


}
