package com.example.demo_sbi.service;

import java.util.List;

import com.example.demo_sbi.model.client.ClientRequest;
import com.example.demo_sbi.model.client.ClientVO;

public interface ClientService {
	ClientVO findClientById(Integer clientId);
	ClientVO insertClient(ClientRequest clientRequest);
	List<ClientVO> batchInsertClient(List<ClientRequest> clientRequests);
	ClientVO updateClient(ClientRequest clientRequest);
	void deleteClientById(Integer clientId);
}
