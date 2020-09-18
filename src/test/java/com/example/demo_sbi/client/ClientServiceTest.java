package com.example.demo_sbi.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import com.example.demo_sbi.exception.ValidateException;
import com.example.demo_sbi.model.client.ClientRequest;
import com.example.demo_sbi.model.client.ClientVO;
import com.example.demo_sbi.model.company.CompanyRequest;
import com.example.demo_sbi.model.company.CompanyVO;
import com.example.demo_sbi.service.client.ClientService;
import com.example.demo_sbi.service.company.CompanyService;
import com.example.demo_sbi.utils.ClientUtil;  

@SpringBootTest
public class ClientServiceTest {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private CompanyService companyService;
	
	private CompanyVO companyVO;
	
	private ClientVO clientVO;
	
	@WithMockUser(username="ADMIN")
	@BeforeEach
	public void beforeInitData() {
		CompanyRequest company = new CompanyRequest();
		company.setAddress("新北市中和區中山路1段32號");
		company.setName("英特爾科技");
		companyVO = companyService.insertCompany(company);
		
		ClientRequest request = generateClientRequest();
		clientVO = clientService.insertClient(request);
	}
	
	@WithMockUser(username="ADMIN")
	@Test
	public void testInsert() {
		ClientRequest request = generateClientRequest();
		clientVO = clientService.insertClient(request);
		
		assertThat(clientVO).isNotNull().isEqualToIgnoringNullFields(ClientUtil.transferPOToVO(ClientUtil.transferRequestToPO(request)));
		
	}
	
	@WithMockUser(username="ADMIN")
	@Test
	public void testUpdate() {
		ClientRequest request = generateClientRequest();
		request.setName("TEST");
		request.setId(clientVO.getId());
		assertThat(clientService.updateClient(request)).isNotNull().isEqualToIgnoringNullFields(ClientUtil.transferPOToVO(ClientUtil.transferRequestToPO(request)));
	}
	
	@Test
	public void testDelete() {
		clientService.deleteClientById(clientVO.getId());
		assertThatThrownBy(() -> clientService.findClientById(clientVO.getId())).isInstanceOf(ValidateException.class).hasMessageContaining("找無客戶資料");
	}
	
	@Test
	public void testGetClient() {
		assertThat(clientService.findClientById(clientVO.getId())).isNotNull().isEqualToComparingFieldByField(clientVO);
	}
	
	@WithMockUser(username="ADMIN")
	@Test
	public void testBatchInsertClient() {
		List<ClientRequest> clientRequests = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			clientRequests.add(generateClientRequest());
		}
		
		assertThat(clientService.batchInsertClient(clientRequests)).isNotEmpty().hasSize(5).allMatch(c -> c.getId() != null);
	}
	
	private ClientRequest generateClientRequest() {
		ClientRequest request = new ClientRequest();
		request.setCompanyId(companyVO.getId());
		request.setEmail("test@gmail.com.tw");
		request.setName("Hank");
		request.setPhone("0223875673");
		return request;
	}
	
}
