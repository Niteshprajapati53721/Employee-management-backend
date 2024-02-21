package com.employee.emprepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.employee;

public interface employeerepo extends JpaRepository<employee, Integer> {

public List<employee> findBycity(String city);
}
