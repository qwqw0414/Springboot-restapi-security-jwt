package com.exp.app.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exp.app.model.vo.User;

@Repository
public class AppDAO {

	@Autowired
	private SqlSessionTemplate sst;

	public int insertUser(User user) throws RuntimeException {
		return sst.insert("app.insertUser", user);
	}

	public User selectOneById(String userId) throws RuntimeException{
		return sst.selectOne("app.selectOneById", userId);
	}

}
