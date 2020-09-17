package com.example.demo_sbi.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo_sbi.model.client.ClientPO;
import com.example.demo_sbi.model.client.ClientRequest;
import com.example.demo_sbi.model.client.ClientVO;
import com.example.demo_sbi.model.company.CompanyPO;


@Component
public class ClientUtil {
	public static ClientVO transferPOToVO(ClientPO clientPO) {
		ClientVO clientVO = new ClientVO();
		BeanUtils.copyProperties(clientPO, clientVO);
		clientVO.setCompanyId(clientPO.getId());
		return clientVO;
	}
	
	public static ClientPO transferRequestToPO(ClientRequest client) {
		ClientPO clientPO = new ClientPO();
		BeanUtils.copyProperties(client, clientPO);
		CompanyPO companyPO = new CompanyPO();
		companyPO.setId(client.getCompanyId());
		clientPO.setCompanyPO(companyPO);
		return clientPO;
	}
	
	public static List<ClientVO> transferPOToVO(List<ClientPO> clientPOs) {
		return clientPOs.stream().map(ClientUtil::transferPOToVO).collect(Collectors.toList());
	}
	
	public static List<ClientPO> transferRequestToPO(List<ClientRequest> client) {
		return client.stream().map(ClientUtil::transferRequestToPO).collect(Collectors.toList());
	}
	
}