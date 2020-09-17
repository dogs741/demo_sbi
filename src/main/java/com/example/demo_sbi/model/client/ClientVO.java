package com.example.demo_sbi.model.client;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "客戶回傳資料")
public class ClientVO implements Serializable {
	private static final long serialVersionUID = -6609232339261596677L;
	
	@ApiModelProperty(value = "客戶編號")
	private Integer id;
	@ApiModelProperty(value = "公司編號")
	private Integer companyId;
	@ApiModelProperty(value = "客戶名稱")
	private String name;
	@ApiModelProperty(value = "客戶信箱")
	private String email;
	@ApiModelProperty(value = "客戶電話")
	private String phone;
	@ApiModelProperty(value = "創建者")
	private String createdBy;
	@ApiModelProperty(value = "創建時間")
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss") 
	private LocalDateTime createdAt;
	@ApiModelProperty(value = "修改者")
	private String updatedBy;
	@ApiModelProperty(value = "修改時間")
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss") 
	private LocalDateTime updatedAt;
	
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
