package com.sng.gdrs.dto;

import java.io.Serializable;

public class AppDetailDto implements Serializable{

	private static final long serialVersionUID = -7013248350698380177L;
	
	private ApplicationDto aDto;
	private String email;
	private String name;
	private String phone;
	private String recruit_title;

	public AppDetailDto() {
	}

	public AppDetailDto(ApplicationDto aDto, String email, String name, String phone, String recruit_title) {
		this.aDto = aDto;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.recruit_title = recruit_title;
	}

	@Override
	public String toString() {
		return "AppDetailDto [aDto=" + aDto + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ ", recruit_title=" + recruit_title + "]";
	}

	public ApplicationDto getaDto() {
		return aDto;
	}

	public void setaDto(ApplicationDto aDto) {
		this.aDto = aDto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRecruit_title() {
		return recruit_title;
	}

	public void setRecruit_title(String recruit_title) {
		this.recruit_title = recruit_title;
	}

}