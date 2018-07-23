package com.ewms.validation;

import com.ewms.PhenixResponce;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.inject.Inject;
import java.util.Map;

@RestControllerAdvice("com.ewms.controller")
public class JavaxValidationAdviceController {

        @Inject
        private ResponseCodeHandler responseCodeHandler;


        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public  PhenixResponce <Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
            return new PhenixResponce<>("VALIDATION_FAILED", responseCodeHandler.resolve(ex.getBindingResult()));

        }


}
