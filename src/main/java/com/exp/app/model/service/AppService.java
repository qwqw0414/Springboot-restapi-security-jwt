package com.exp.app.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.app.model.dao.AppDAO;
import com.exp.app.model.vo.User;

@Service
public class AppService {

	@Autowired
	private AppDAO appDAO;

	public int signup(User user) {
		return appDAO.insertUser(user);
	}
	
}
