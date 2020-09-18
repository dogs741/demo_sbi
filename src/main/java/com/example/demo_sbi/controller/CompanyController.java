package com.example.demo_sbi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_sbi.model.SBIBaseResponse;
import com.example.demo_sbi.model.company.CompanyRequest;
import com.example.demo_sbi.model.company.CompanyVO;
import com.example.demo_sbi.service.company.CompanyService;
import com.example.demo_sbi.utils.ResponseUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('OPERATOR') OR hasRole('MANAGER')")
	@ApiOperation(value = "取得公司資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功取得公司資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "取得公司資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "取得公司資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<CompanyVO> query(@PathVariable("id") Integer companyId) {
		return ResponseUtil.generateResponse(companyService.findCompanyById(companyId));
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN') OR hasRole('OPERATOR')")
	@ApiOperation(value = "新增公司資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功新增公司資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "新增公司資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "新增公司資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<Void> create(@Valid @RequestBody CompanyRequest companyRequest) {
		companyService.insertCompany(companyRequest);
		return ResponseUtil.SUCCESS;
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('MANAGER')")
	@ApiOperation(value = "修改公司資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功修改公司資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "修改公司資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "修改公司資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<Void> update(@PathVariable("id") Integer companyId, @Valid @RequestBody CompanyRequest companyRequest) {
		companyRequest.setId(companyId);
		companyService.updateCompany(companyRequest);
		return ResponseUtil.SUCCESS;
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('MANAGER')")
	@ApiOperation(value = "刪除公司資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功刪除公司資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "刪除公司資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "刪除公司資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<Void> delete(@PathVariable("id") Integer companyId) {
		companyService.deleteCompanyById(companyId);
		return ResponseUtil.SUCCESS;
	}
}
