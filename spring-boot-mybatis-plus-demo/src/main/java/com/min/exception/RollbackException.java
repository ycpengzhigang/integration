package com.min.exception;

public class RollbackException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6322499602581368235L;
	
	private String msg;
	
	private Integer code;

	
	public RollbackException(String msg, Integer code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public RollbackException(String msg, Integer code,  Throwable cause) {
		super(msg, cause);
		this.msg = msg;
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
