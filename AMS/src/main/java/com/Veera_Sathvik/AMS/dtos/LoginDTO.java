package com.Veera_Sathvik.AMS.dtos;

public class LoginDTO {

	private String userId;
	private String password;

	public LoginDTO(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", password=" + password + "]";
	}
}
