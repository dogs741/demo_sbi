package com.example.demo_sbi.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.demo_sbi.exception.ValidateException;
import com.example.demo_sbi.model.SBIBaseResponse;
import com.example.demo_sbi.utils.ResponseUtil;

@RestControllerAdvice
public class SBIExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//格式錯誤
	@ExceptionHandler({
		MethodArgumentTypeMismatchException.class, 
		MissingServletRequestParameterException.class, 
		})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
    public SBIBaseResponse<Void> handleValidateException(Exception ex){
		logger.warn("server warn:{}", ex.getMessage());
        return ResponseUtil.FAILURE;
    }
	
	//找無資料
	@ExceptionHandler(ValidateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public SBIBaseResponse<Void> handleEntityNotFoundException(Exception ex){
		logger.warn("server warn:{}", ex.getMessage());
		return ResponseUtil.NO_DATA_FOUND;
	}
	
	//內部錯誤
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public SBIBaseResponse<Void> handleException(Exception ex){
		logger.error("server error:{}", ex.getMessage());
        return ResponseUtil.ERRORS;
    }
}
