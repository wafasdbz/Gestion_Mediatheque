package com.example.gestionMed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class DepassementQuotaException extends Exception {
	
	public DepassementQuotaException(String message) {
		
		System.out.println(message);
	}

}
