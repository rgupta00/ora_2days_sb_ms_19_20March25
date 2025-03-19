package com.productapp.dto;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//Lombok?
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ErrorInfo {
	private String errorMessage;
	private int errorCode;
	private String toContact;
	private LocalDateTime timeStamp;
	
}
