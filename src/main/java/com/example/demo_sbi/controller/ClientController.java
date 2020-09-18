package com.example.demo_sbi.controller;

import java.util.List;

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
import com.example.demo_sbi.model.client.ClientRequest;
import com.example.demo_sbi.model.client.ClientVO;
import com.example.demo_sbi.service.client.ClientService;
import com.example.demo_sbi.utils.ResponseUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('OPERATOR') OR hasRole('MANAGER')")
	@ApiOperation(value = "取得客戶資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功取得客戶資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "取得客戶資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "取得客戶資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<ClientVO> query(@PathVariable("id") Integer clientId) {
		return ResponseUtil.generateResponse(clientService.findClientById(clientId));
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN') OR hasRole('OPERATOR')")
	@ApiOperation(value = "新增客戶資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功新增客戶資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "新增客戶資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "新增客戶資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<Void> create(@Valid @RequestBody ClientRequest clientRequest) {
		clientService.insertClient(clientRequest);
		return ResponseUtil.SUCCESS;
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('MANAGER')")
	@ApiOperation(value = "修改客戶資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功修改客戶資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "修改客戶資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "修改客戶資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<Void> update(@PathVariable("id") Integer clientId, @Valid @RequestBody ClientRequest clientRequest) {
		clientRequest.setId(clientId);
		clientService.updateClient(clientRequest);
		return ResponseUtil.SUCCESS;
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('MANAGER')")
	@ApiOperation(value = "刪除客戶資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功刪除客戶資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "刪除客戶資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "刪除客戶資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<Void> delete(@PathVariable("id") Integer clientId) {
		clientService.deleteClientById(clientId);
		return ResponseUtil.SUCCESS;
	}
	
	@PostMapping("/list")
	@PreAuthorize("hasRole('ADMIN') OR hasRole('OPERATOR')")
	@ApiOperation(value = "新增多筆客戶資訊")
	@ApiResponses({
		@ApiResponse(code = 200, message = "成功新增多筆客戶資訊", response = SBIBaseResponse.class),
		@ApiResponse(code = 400, message = "新增多筆客戶資訊失敗", response = SBIBaseResponse.class),
		@ApiResponse(code = 500, message = "新增多筆客戶資訊失敗", response = SBIBaseResponse.class)})
	public SBIBaseResponse<Void> batchAdd(@Valid @RequestBody List<ClientRequest> clientRequests) {
		clientService.batchInsertClient(clientRequests);
		return ResponseUtil.SUCCESS;
	}
}
