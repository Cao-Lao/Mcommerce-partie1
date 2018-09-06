package com.ecommerce.microcommerce.web.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FreeProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FreeProductException(final String message) {

		super(message);
	}

}
