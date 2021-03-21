package com.flights.api.controller;

import com.flights.api.model.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.flights.api.Utils.formatError;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        BindingResult bindingResult = ex.getBindingResult();
        List<String> errors = new ArrayList<>();
        bindingResult.getFieldErrors()
                .forEach(error -> errors.add(formatError(error.getField(), error.getDefaultMessage())));
        bindingResult.getGlobalErrors()
                .forEach(error -> errors.add(formatError(error.getObjectName(), error.getDefaultMessage())));

        return handleException(ex, request,
                new ApiError(ex.getMessage(), errors), BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers,
                                                                          HttpStatus status, WebRequest request) {

        return handleException(ex, request,
                new ApiError(ex.getMessage(), Collections.emptyList()), BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpStatusCodeException.class})
    protected ResponseEntity<Object> handleHttpStatusCodeException(HttpStatusCodeException ex, WebRequest request) {

        return handleException(ex, request,
                ex.getResponseBodyAsString(), ex.getStatusCode());
    }

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {

        return handleException(ex, request,
                new ApiError(ex.getMessage(), Collections.emptyList()), INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> handleException(Exception e, WebRequest webRequest, Object body, HttpStatus httpStatus) {

        return handleExceptionInternal(e, body, new HttpHeaders(), httpStatus, webRequest);
    }
}
