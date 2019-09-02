package com.vojs.bean;

import net.sf.json.JSONArray;

import java.util.List;

public class Response {

	private String success;
	
	private String error;
	
	private UcUser user;
	
	private List<UcUser> users;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public UcUser getUser() {
		return user;
	}

	public void setUser(UcUser user) {
		this.user = user;
	}

	public List<UcUser> getUsers() {
		String str = JSONArray.fromObject(users).toString();
		System.out.println(str);
		users = JSONArray.toList(JSONArray.fromObject(users), UcUser.class);
		return users;
	}

	public void setUsers(List<UcUser> users) {
		this.users = users;
	}
	
}
