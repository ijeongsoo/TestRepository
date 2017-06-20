package com.mycompany.myapp.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class NoAccountExceptionHandler {
	
	@ExceptionHandler
	public String handleNoAccountException(NoAccountException e, Model model){
		model.addAttribute("reason", e.getMessage());
		return "transaction/exam02";
	}
}
