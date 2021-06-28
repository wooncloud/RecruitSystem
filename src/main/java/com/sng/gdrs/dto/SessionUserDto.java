package com.sng.gdrs.dto;

import java.io.Serializable;

public class SessionUserDto implements Serializable {

	private static final long serialVersionUID = 8417908297992315392L;

	// 시큐리티에 기능 있어서 선생님이 참고 자료 주신다고 했는데 확인 후 미사용하게 될 시 이친구는 bye

	private String email;
	private String name;
	private String auth;
	private String emailcheck;

	public SessionUserDto() {
	}

	public SessionUserDto(String email, String name, String auth, String emailcheck) {
		this.email = email;
		this.name = name;
		this.auth = auth;
		this.emailcheck = emailcheck;
	}

	@Override
	public String toString() {
		return "SessionUserDto [email=" + email + ", name=" + name + ", auth=" + auth + ", emailcheck=" + emailcheck
				+ "]";
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

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getEmailcheck() {
		return emailcheck;
	}

	public void setEmailcheck(String emailcheck) {
		this.emailcheck = emailcheck;
	}

}
