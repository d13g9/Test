package com.Test.Test.com.Test.Test;


public class Organization {

	private String description;
	private String code;
	

	public Organization(String description, String code) {
		super();
		this.description = description;
		this.code = code;
	}
	
	public Organization() {
		// TODO Auto-generated constructor stub
	}

	public String getDesctiption() {
		return description;
	}
	
	public void setDesctiption(String desctiption) {
		this.description = desctiption;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Organization [description=" + description + ", code=" + code +  "]";
	}
	
}
