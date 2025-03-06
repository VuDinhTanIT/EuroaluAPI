package com.euroaluAPI.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	ResponseEntity<?> handlingValidation(MethodArgumentNotValidException exception) {
		String enumKey = exception.getFieldError().getDefaultMessage();
		;

		return ResponseEntity.badRequest().body(enumKey);
	}

	@ExceptionHandler(value = Exception.class)
	ResponseEntity<?> handlingRuntimeException(Exception exception) {
		log.error("Exception: ", exception);

		return ResponseEntity.badRequest().body(exception.getMessage());
	}
//	@ExceptionHandler(value = AppException.class)
//	ResponseEntity<ApiResponse> handlingAppException(AppException exception) {
//		ErrorCode errorCode = exception.getErrorCode();
//		ApiResponse apiResponse = new ApiResponse();
//
//		apiResponse.setCode(errorCode.getCode());
//		apiResponse.setMessage(exception.getMessage());
//		log.info("Global AppException  ");
//		return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
//	}

	@ExceptionHandler(value = AccessDeniedException.class)
	ResponseEntity<?> handlingAccessDeniedException(AccessDeniedException exception) {
		log.info("GlobalExceptionclass được bắt lỗi: ");
		exception.printStackTrace();
		return ResponseEntity.status(401).body(exception);
	}

	// Xử lý lỗi 404 (NoHandlerFoundException)
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<?> handleNoHandlerFoundException(NoHandlerFoundException ex) {
//        logger.error("Requested URL not found: {}", ex.getRequestURL());
//    	ErrorCode errorCode = ex.getErrorCode();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex);
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	ResponseEntity<?> handlingAccessDeniedException(RuntimeException exception) {
		log.info("GlobalExceptionclass được bắt lỗi RntimeEX");
		exception.getCause();
		return ResponseEntity.status(401).body(exception.getLocalizedMessage());
	}

}