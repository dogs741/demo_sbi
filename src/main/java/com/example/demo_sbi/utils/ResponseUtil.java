package com.example.demo_sbi.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.demo_sbi.model.SBIBaseResponse;


@Component
public class ResponseUtil {
	
	public final static SBIBaseResponse<Void> SUCCESS = new SBIBaseResponse<>(HttpStatus.OK.value(), "Success");
	public final static SBIBaseResponse<Void> FAILURE = new SBIBaseResponse<>(HttpStatus.BAD_REQUEST.value(), "Failed");
	public final static SBIBaseResponse<Void> NO_DATA_FOUND = new SBIBaseResponse<>(HttpStatus.BAD_REQUEST.value(), "No Data Found");
	public final static SBIBaseResponse<Void> ERRORS = new SBIBaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Server Errors");
	
	public static <T> SBIBaseResponse<T> generateResponse(T data) {
		SBIBaseResponse<T> response = new SBIBaseResponse<T>();
		response.setCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(data);
		return response;
	}
	
}