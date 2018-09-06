package com.ecommerce.microcommerce.web.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotFoundProductException(final String message) {

		super(message);
	}
}
