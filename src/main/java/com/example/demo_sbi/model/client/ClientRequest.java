package com.example.demo_sbi.model.client;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "客戶資訊")
public class ClientRequest implements Serializable {
	private static final long serialVersionUID = -6609232339261596677L;
	
	@ApiModelProperty(value = "客戶編號", example = "1")
	private Integer id;
	@ApiModelProperty(value = "公司編號", required = true, example = "1")
	@NotNull(message="公司 ID 為必填")
	private Integer companyId;
	@ApiModelProperty(value = "客戶名稱", required = true, example = "Jack")
	@NotBlank(message="客戶名稱為必填")
	private String name;
	@ApiModelProperty(value = "客戶信箱", required = true, example = "test@gmail.com.tw")
	@NotBlank(message="客戶信箱為必填")
	@Email(regexp=".*@.*\\..*", message = "必須為有效信箱")
	private String email;
	@ApiModelProperty(value = "客戶電話", required = true, example = "0229513267")
	@NotBlank(message="客戶電話為必填")
	private String phone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
