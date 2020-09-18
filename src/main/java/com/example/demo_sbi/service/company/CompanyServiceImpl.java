package com.example.demo_sbi.service.company;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo_sbi.exception.ValidateException;
import com.example.demo_sbi.exception.ValidateException.LogicType;
import com.example.demo_sbi.model.company.CompanyPO;
import com.example.demo_sbi.model.company.CompanyRequest;
import com.example.demo_sbi.model.company.CompanyVO;
import com.example.demo_sbi.repository.CompanyRepository;
import com.example.demo_sbi.utils.AuthUtil;
import com.example.demo_sbi.utils.CompanyUtil;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public CompanyVO findCompanyById(Integer companyId) {
		Optional<CompanyPO> result = companyRepository.findById(companyId);
		if(!result.isPresent()) {
			throw new ValidateException(LogicType.NODATA, "找無公司資料");
		}
		return CompanyUtil.transferPOToVO(result.get());
	}

	@Transactional
	@Override
	public CompanyVO insertCompany(CompanyRequest companyRequest) {
		CompanyPO companyPO = CompanyUtil.transferRequestToPO(companyRequest);
		companyPO.setCreatedAt(LocalDateTime.now());
		companyPO.setCreatedBy(AuthUtil.getUserName());
		return CompanyUtil.transferPOToVO(companyRepository.save(companyPO));
	}

	@Transactional
	@Override
	public CompanyVO updateCompany(CompanyRequest companyRequest) {
		Optional<CompanyPO> result = companyRepository.findById(companyRequest.getId());
		if(!result.isPresent()) {
			throw new ValidateException(LogicType.NODATA, "找無公司資料");
		}
		
		CompanyPO companyPO = result.get();
		BeanUtils.copyProperties(companyRequest, companyPO);
		companyPO.setUpdatedAt(LocalDateTime.now());
		companyPO.setUpdatedBy(AuthUtil.getUserName());
		return CompanyUtil.transferPOToVO(companyRepository.save(companyPO));
	}

	@Transactional
	@Override
	public void deleteCompanyById(Integer companyId) {
		companyRepository.deleteById(companyId);
	}

}
