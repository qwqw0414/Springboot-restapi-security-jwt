package com.exp.app.model.vo;

import lombok.Data;

@Data
public class User {

	private String id;
	private String password;
	private UserRole role;
	
}
