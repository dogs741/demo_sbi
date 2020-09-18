package com.example.demo_sbi.service.company;

import com.example.demo_sbi.model.company.CompanyRequest;
import com.example.demo_sbi.model.company.CompanyVO;

public interface CompanyService {
	CompanyVO findCompanyById(Integer companyId);
	CompanyVO insertCompany(CompanyRequest companyRequest);
	CompanyVO updateCompany(CompanyRequest companyRequest);
	void deleteCompanyById(Integer companyId);
}
