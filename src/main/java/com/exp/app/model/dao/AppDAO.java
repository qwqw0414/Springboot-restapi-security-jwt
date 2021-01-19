package com.exp.app.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exp.app.model.vo.User;

@Repository
public class AppDAO {

	@Autowired
	private SqlSessionTemplate sst;

	public int insertUser(User user) {
		return sst.insert("app.insertUser", user);
	}
	
}
