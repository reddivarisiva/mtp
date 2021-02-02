package com.mtp.demo.app.util;

import java.util.List;

public class BeneAdminSystem {
	

	private String name;
	private String url;
	private List<String> inputParams;
	private String security;
	private String responseType;
	private String operation;
	private String responseData;
	
	public BeneAdminSystem(String name, String operation, String url, List<String> inputParams, String security, String responseType) {
		super();
		this.name = name;
		this.operation = operation;
		this.url = url;
		this.inputParams = inputParams;
		this.security = security;
		this.responseType = responseType;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getInputParams() {
		return inputParams;
	}
	public void setInputParams(List<String> inputParams) {
		this.inputParams = inputParams;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getResponseType() {
		return responseType;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

}
