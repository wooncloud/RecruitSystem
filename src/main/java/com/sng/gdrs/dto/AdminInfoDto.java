package com.sng.gdrs.dto;

import java.io.Serializable;

public class AdminInfoDto implements Serializable {

	private static final long serialVersionUID = 3370414582412709875L;

	private String email;
	private String password;
	private String name;
	private int admingrade;
	private String delflag;
	
	public AdminInfoDto() {
	}

	public AdminInfoDto(String email, String password, String name, int admingrade, String delflag) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.admingrade = admingrade;
		this.delflag = delflag;
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

	public int getAdmingrade() {
		return admingrade;
	}

	public void setAdmingrade(int admingrade) {
		this.admingrade = admingrade;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	@Override
	public String toString() {
		return "AdminInfoDto [email=" + email + ", password=" + password + ", name=" + name + ", admingrade="
				+ admingrade + ", delflag=" + delflag + "]";
	}

}
