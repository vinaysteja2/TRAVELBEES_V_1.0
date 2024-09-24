package com.gateway.payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	
	private String msg;
	private HttpStatus status;
	private boolean sucess;
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApiResponse(String msg, HttpStatus status, boolean sucess) {
		super();
		this.msg = msg;
		this.status = status;
		this.sucess = sucess;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public boolean isSucess() {
		return sucess;
	}
	public void setSucess(boolean sucess) {
		this.sucess = sucess;
	}
	@Override
	public String toString() {
		return "ApiResponse [msg=" + msg + ", status=" + status + ", sucess=" + sucess + "]";
	}
	
	

}
