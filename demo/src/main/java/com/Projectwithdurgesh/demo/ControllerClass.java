package com.Projectwithdurgesh.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {

	@RequestMapping("/gaurav")
	public String gaurav() {
		return "This is just for testing purpose";
	}
	
}
