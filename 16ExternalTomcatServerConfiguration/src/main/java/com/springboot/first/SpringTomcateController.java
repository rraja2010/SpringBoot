package com.springboot.first;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringTomcateController {
	
	@RequestMapping("/external")
	public String externalTomcatConfiguration(){
		String str = "External Tomcat Configuration has been done successfully!!";
		return str;
	}
}
