package com.acme.ecom.product.commons.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.acme.ecom.product.commons.lang.ProductConflictException;

@ControllerAdvice
public class ProductConflictAdvice {

    @ResponseBody
    @ExceptionHandler(ProductConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String productNotFoundHandler(ProductConflictException ex) {
      return ex.getMessage();
    }
    
}
