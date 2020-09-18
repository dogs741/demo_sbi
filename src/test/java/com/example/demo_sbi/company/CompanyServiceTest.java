package com.example.demo_sbi.company;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import com.example.demo_sbi.exception.ValidateException;
import com.example.demo_sbi.model.company.CompanyRequest;
import com.example.demo_sbi.model.company.CompanyVO;
import com.example.demo_sbi.service.company.CompanyService;
import com.example.demo_sbi.utils.CompanyUtil;

@SpringBootTest
public class CompanyServiceTest {
	
	@Autowired
	private CompanyService companyService;
	
	private CompanyVO companyVO;
	
	@WithMockUser(username="ADMIN")
	@BeforeEach
	public void beforeInitData() {
		CompanyRequest company = generateCompanyRequest();
		companyVO = companyService.insertCompany(company);
	}
	
	@WithMockUser(username="ADMIN")
	@Test
	public void testInsert() {
		assertThat(companyVO).isNotNull().isEqualToIgnoringNullFields(CompanyUtil.transferPOToVO(CompanyUtil.transferRequestToPO(generateCompanyRequest())));
	}
	
	@WithMockUser(username="ADMIN")
	@Test
	public void testUpdate() {
		CompanyRequest request = generateCompanyRequest();
		request.setName("GOOGLE");
		request.setId(companyVO.getId());
		CompanyVO companyVO = companyService.updateCompany(request);
		assertThat(companyVO).isNotNull().isEqualToIgnoringNullFields(CompanyUtil.transferPOToVO(CompanyUtil.transferRequestToPO(request)));
		assertThat(companyVO.getCreatedBy()).isEqualTo("ADMIN");
		assertThat(companyVO.getUpdatedBy()).isEqualTo("ADMIN");
	}
	
	@Test
	public void testDelete() {
		companyService.deleteCompanyById(companyVO.getId());
		assertThatThrownBy(() -> companyService.findCompanyById(companyVO.getId())).isInstanceOf(ValidateException.class).hasMessageContaining("找無公司資料");
	}
	
	@Test
	void testGetCompany() {
		assertThat(companyService.findCompanyById(companyVO.getId())).isNotNull().isEqualToComparingFieldByField(companyVO);
	}
	
	private CompanyRequest generateCompanyRequest() {
		CompanyRequest company = new CompanyRequest();
		company.setAddress("新北市中和區中山路1段32號");
		company.setName("英特爾科技");
		companyVO = companyService.insertCompany(company);
		return company;
	}
}
