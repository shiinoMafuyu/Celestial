package com.dn.process;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(value=JsonInclude.Include.NON_NULL)
public class Result {
	private String message;
	
	private Integer retcode;
	
	private Object Data;
	
	public Result() {
		super();
	}

	public Result(String message, Integer retcode, Object data) {
		super();
		this.message = message;
		this.retcode = retcode;
		Data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getRetcode() {
		return retcode;
	}

	public void setRetcode(Integer retcode) {
		this.retcode = retcode;
	}

	public Object getData() {
		return Data;
	}

	public void setData(Object data) {
		Data = data;
	}

	@Override
	public String toString() {
		return "Result [message=" + message + ", retcode=" + retcode
				+ ", Data=" + Data + "]";
	}
	
}
