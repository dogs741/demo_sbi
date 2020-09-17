package com.example.demo_sbi.model;

public class SBIBaseResponse<T> {
	private T data;
	private Integer code;
	private String message;
	
	public SBIBaseResponse() {
		
	}
	
	public SBIBaseResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
