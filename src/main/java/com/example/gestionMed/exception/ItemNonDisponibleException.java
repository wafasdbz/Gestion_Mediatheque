package com.example.gestionMed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ItemNonDisponibleException extends Exception {

	public ItemNonDisponibleException(String message) {

		System.out.println(message);
	}


}
