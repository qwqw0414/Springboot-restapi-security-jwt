package com.exp.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exp.app.common.security.jwt.JwtTokenProvider;
import com.exp.app.model.service.AppService;
import com.exp.app.model.vo.User;
import com.exp.app.model.vo.UserRole;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class AppController {

	private Gson gson = new Gson();
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private AppService appService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping(value = "/home")
	public String home() {
		return "connected !!";
	}
	
	@PostMapping(value = "/signup")
	public String signup(@RequestBody User user) {

		log.info("param : {}", user);
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		int result = appService.signup(user);
		
		return gson.toJson(user);
	}
	
	
	@PostMapping(value = "/signin")
	public String signin(@RequestBody Map<String, String> param) {
		
		log.info("param : {}", param);
		
		User user = appService.selectOneById(param.get("id"));
		log.info("user : {}", user);
		
		if( !passwordEncoder.matches(param.get("password"), user.getPassword()))
			throw new RuntimeException("miss");
		
		List<UserRole> auth = new ArrayList<>();
		auth.add(user.getRole());
		
		return jwtTokenProvider.createToken(user.getId(), auth);
	}
	
	@GetMapping(value = "/admin")
	public String adminPage() {
		return "admin";
	}
	
	@GetMapping(value = "/user")
	public String userPage() {
		return "user";
	}
}
