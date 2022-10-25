package com.example.gestionMed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class DepassementQuotaException extends Exception {
	
	public DepassementQuotaException(String message) {
		
		System.out.println(message);
	}

}
