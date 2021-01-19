package com.exp.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/api")
public class AppController {

	@GetMapping(value = "/home")
	public String home() {
		return "connected !!";
	}
	
	
}
