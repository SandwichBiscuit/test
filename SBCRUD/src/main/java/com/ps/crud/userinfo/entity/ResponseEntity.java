package com.ps.crud.userinfo.entity;

import java.util.List;

public class ResponseEntity {
	
	//返回状态
	private Integer code=0;
	private String mas="";
	//数据总数
	private Integer count=0;
	//返回集合
	private List<User> data;

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMas() {
		return mas;
	}
	public void setMas(String mas) {
		this.mas = mas;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}

	
	
}
