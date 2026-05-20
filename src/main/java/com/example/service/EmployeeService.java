package com.example.service;

import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 従業員関連の業務処理を行うサービス.
 */
@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

}
