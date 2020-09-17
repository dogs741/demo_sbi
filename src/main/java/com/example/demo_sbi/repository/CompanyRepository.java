package com.example.demo_sbi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_sbi.model.company.CompanyPO;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyPO, Integer> {

}
