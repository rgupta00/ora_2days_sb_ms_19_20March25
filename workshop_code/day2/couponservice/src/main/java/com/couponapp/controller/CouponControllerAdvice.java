package com.couponapp.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.couponapp.dto.ErrorInfo;
import com.couponapp.exceptions.CouponNotFoundException;

@RestControllerAdvice //under the hood it use aop
public class CouponControllerAdvice {
	
	@Value("${prodctapp.toContact}")
	private String toContact;
	
	@ExceptionHandler(CouponNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(CouponNotFoundException ex){
		ErrorInfo errorInfo=ErrorInfo.builder()
				.errorCode(404)
				.timeStamp(LocalDateTime.now())
				.toContact(toContact)
				.errorMessage(ex.getMessage())
				.build();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorInfo);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> handle400(MethodArgumentNotValidException ex){
		//from ex object i want to get actual cause of the error
		String errorString=ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(e->e.getDefaultMessage())
				.collect(Collectors.joining(","));
		
		
		ErrorInfo errorInfo=ErrorInfo.builder()
				.errorCode(400)
				.timeStamp(LocalDateTime.now())
				.toContact(toContact)
				.errorMessage(errorString)
				.build();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> handle500(Exception ex){
		ErrorInfo errorInfo=ErrorInfo.builder()
				.errorCode(500)
				.timeStamp(LocalDateTime.now())
				.toContact(toContact)
				.errorMessage("pls try after some")
				.build();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
	}

}
