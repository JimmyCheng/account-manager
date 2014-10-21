package com.jeecourse.account.rest.v1;


import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


public class RestExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(value = { RestException.class })
	public final ResponseEntity<?> handleException(RestException ex, WebRequest request) {
		HttpHeaders headers = new HttpHeaders();
		return handleExceptionInternal(ex, ex.getMessage(), headers, ex.status, request);
	}


}
