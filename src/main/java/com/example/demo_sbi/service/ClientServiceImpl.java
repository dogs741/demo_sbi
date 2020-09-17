package com.example.demo_sbi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_sbi.exception.ValidateException;
import com.example.demo_sbi.exception.ValidateException.LogicType;
import com.example.demo_sbi.model.client.ClientPO;
import com.example.demo_sbi.model.client.ClientRequest;
import com.example.demo_sbi.model.client.ClientVO;
import com.example.demo_sbi.model.company.CompanyPO;
import com.example.demo_sbi.repository.ClientRepository;
import com.example.demo_sbi.repository.CompanyRepository;
import com.example.demo_sbi.utils.AuthUtil;
import com.example.demo_sbi.utils.ClientUtil;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public ClientVO findClientById(Integer clientId) {
		Optional<ClientPO> result = clientRepository.findById(clientId);
		if(!result.isPresent()) {
			throw new ValidateException(LogicType.NODATA, "找無客戶資料");
		}
		return ClientUtil.transferPOToVO(result.get());
	}

	@Override
	public ClientVO insertClient(ClientRequest clientRequest) {
		ClientPO clientPO = ClientUtil.transferRequestToPO(clientRequest);
		clientPO.setCreatedAt(LocalDateTime.now());
		clientPO.setCreatedBy(AuthUtil.getUserName());
		return ClientUtil.transferPOToVO(clientRepository.save(clientPO));
	}

	@Override
	public ClientVO updateClient(ClientRequest clientRequest) {
		
		Optional<ClientPO> client = clientRepository.findById(clientRequest.getId());
		if(!client.isPresent()) {
			throw new ValidateException(LogicType.NODATA, "找無客戶資料");
		}
		Optional<CompanyPO> company = companyRepository.findById(clientRequest.getCompanyId());
		if(!company.isPresent()) {
			throw new ValidateException(LogicType.NODATA, "公司 ID 錯誤, 找無公司資料");
		}
		
		ClientPO clientPO = client.get();
		BeanUtils.copyProperties(clientRequest, clientPO);
		clientPO.setUpdatedAt(LocalDateTime.now());
		clientPO.setUpdatedBy(AuthUtil.getUserName());
		return ClientUtil.transferPOToVO(clientRepository.save(clientPO));
	}

	@Override
	public void deleteClientById(Integer clientId) {
		clientRepository.deleteById(clientId);
	}

	@Override
	public List<ClientVO> batchInsertClient(List<ClientRequest> clientRequests) {
		List<ClientPO> clientPOs = ClientUtil.transferRequestToPO(clientRequests);
		clientPOs.forEach(client -> {
			client.setCreatedAt(LocalDateTime.now());
			client.setCreatedBy(AuthUtil.getUserName());
		});
		return ClientUtil.transferPOToVO(clientRepository.saveAll(clientPOs));
	}
	
}
