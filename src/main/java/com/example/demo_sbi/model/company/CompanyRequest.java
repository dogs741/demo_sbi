package com.example.demo_sbi.model.company;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "公司資訊")
public class CompanyRequest implements Serializable {
	private static final long serialVersionUID = 3562266955059537175L;
	
	@ApiModelProperty(value = "公司編號", example = "1")
	private Integer id;
	@ApiModelProperty(value = "公司名稱", required = true, example = "中華電信公司")
	@NotBlank(message="公司名稱為必填")
	private String name;
	@ApiModelProperty(value = "公司地址", required = true, example = "台北市中山區中山北路2段31號5樓")
	@NotBlank(message="公司地址為必填")
	private String address;

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
}
