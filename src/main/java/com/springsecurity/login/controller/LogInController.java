package com.springsecurity.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

	@GetMapping(value = { "/", "/index" })
	public String index() {
		return "login";
	}

	@GetMapping(value = { "/error" })
	public String error() {
		return "error";
	}
}
