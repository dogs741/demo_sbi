package com.example.demo_sbi.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.demo_sbi.model.company.CompanyPO;
import com.example.demo_sbi.model.company.CompanyRequest;
import com.example.demo_sbi.model.company.CompanyVO;


@Component
public class CompanyUtil {
	public static CompanyVO transferPOToVO(CompanyPO companyPO) {
		CompanyVO companyVO = new CompanyVO();
		BeanUtils.copyProperties(companyPO, companyVO);
		return companyVO;
	}
	
	public static CompanyPO transferRequestToPO(CompanyRequest company) {
		CompanyPO companyPO = new CompanyPO();
		BeanUtils.copyProperties(company, companyPO);
		return companyPO;
	}
	
	
}