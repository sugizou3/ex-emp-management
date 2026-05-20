package com.example.service;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 従業員関連の業務処理を行うサービス.
 */
@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    /**
     * 従業員情報を全件取得する.
     *
     * @return 従業員情報
     */
    public List<Employee> showList() {
        return repository.findAll();
    }

    /**
     * 主キーに一致する従業員情報を取得.
     *
     * @param id 主キー
     * @return 従業員情報
     */
    public Employee showDetail(Integer id) {
        return repository.findById(id);
    }

    public void updateDependentsCount(Integer employeeId, Integer newCount) {
        Employee employee = repository.findById(employeeId);
        employee.setDependentsCount(newCount);
        repository.update(employee);
    }

}
