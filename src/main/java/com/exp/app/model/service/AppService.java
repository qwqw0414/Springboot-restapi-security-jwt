package com.exp.app.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.app.model.dao.AppDAO;
import com.exp.app.model.vo.User;
import com.exp.app.model.vo.UserRole;

@Service
public class AppService {

	@Autowired
	private AppDAO appDAO;

	public int signup(User user) throws RuntimeException {
		user.setRole(UserRole.ROLE_USER);
		return appDAO.insertUser(user);
	}

	public User selectOneById(String userId) throws RuntimeException{
		return appDAO.selectOneById(userId);
	}

}
