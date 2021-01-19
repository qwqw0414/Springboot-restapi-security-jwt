package com.exp.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.app.model.service.AppService;
import com.exp.app.model.vo.User;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/api")
public class AppController {

	private Gson gson = new Gson();
	
	@Autowired
	public AppService appService;
	
	@GetMapping(value = "/home")
	public String home() {
		return "connected !!";
	}
	
	@PostMapping(value = "/signup")
	public String signup(User user) {

		int result = appService.signup(user);
		
		return gson.toJson(user);
	}
	
	
}
