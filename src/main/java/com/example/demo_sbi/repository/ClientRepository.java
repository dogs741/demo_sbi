package com.example.demo_sbi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_sbi.model.client.ClientPO;

@Repository
public interface ClientRepository extends JpaRepository<ClientPO, Integer> {
	
}
