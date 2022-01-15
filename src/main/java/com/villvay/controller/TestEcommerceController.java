package com.villvay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEcommerceController {

	@RequestMapping({ "/ecommerce" })
	public String accessEcommerce() {
		return "Success";
	}

}