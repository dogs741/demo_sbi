package com.example.demo_sbi.exception;
public class ValidateException extends RuntimeException {

	private static final long serialVersionUID = 8362987233908270648L;
	private LogicType logicType = LogicType.DEFAULT;
	private String message;

	public enum LogicType {
		NODATA, DEFAULT;
	}
	
	public ValidateException(LogicType logicType, String message) {
		super(message);
		if (logicType != null) {
			this.logicType = logicType;
		}
		this.message = message;
	}

	public LogicType getLogicType() {
		return logicType;
	}

	public String getMessage() {
		return message;
	}
}