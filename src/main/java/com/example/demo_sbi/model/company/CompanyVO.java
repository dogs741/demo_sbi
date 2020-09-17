package com.example.demo_sbi.model.company;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "公司回傳資料")
public class CompanyVO implements Serializable {
	private static final long serialVersionUID = 3562266955059537175L;
	
	@ApiModelProperty(value = "公司編號")
	private Integer id;
	@ApiModelProperty(value = "公司名稱")
	private String name;
	@ApiModelProperty(value = "公司地址")
	private String address;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
