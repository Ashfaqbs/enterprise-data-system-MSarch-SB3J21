package com.ashfaq.dev.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RefreshScope
@RestController
public class MessageController {

	@Value("${message}")
	private String message;
	
	@GetMapping("/message")
	public String getMessage() {
		return this.message;
	}
	
}
