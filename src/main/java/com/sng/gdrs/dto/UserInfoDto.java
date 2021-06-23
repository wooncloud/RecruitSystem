package com.sng.gdrs.dto;

import java.io.Serializable;

public class UserInfoDto implements Serializable {

	private static final long serialVersionUID = 4590910370702836297L;
	
	private String email;
	private String password;
	private String name;
	private String birth;
	private String phone;
	private String delflag;
	private String emailcheck;
	
	public UserInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoDto(String email, String password, String name, String birth, String phone, String delflag,
			String emailcheck) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
		this.delflag = delflag;
		this.emailcheck = emailcheck;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getEmailcheck() {
		return emailcheck;
	}

	public void setEmailcheck(String emailcheck) {
		this.emailcheck = emailcheck;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserInfoDto [email=" + email + ", password=" + password + ", name=" + name + ", birth=" + birth
				+ ", phone=" + phone + ", delflag=" + delflag + ", emailcheck=" + emailcheck + "]";
	}
	
	
	
}
