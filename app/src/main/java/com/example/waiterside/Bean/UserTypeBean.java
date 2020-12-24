package com.example.waiterside.Bean;

public class UserTypeBean {

	private int userTypeId;
	private String userTypeName;
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Override
	public String toString() {
		return "UserTypeBean{" +
				"userTypeId=" + userTypeId +
				", userTypeName='" + userTypeName + '\'' +
				'}';
	}
}
