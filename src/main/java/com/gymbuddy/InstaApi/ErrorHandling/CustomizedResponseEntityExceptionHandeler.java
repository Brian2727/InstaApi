package com.gymbuddy.InstaApi.ErrorHandling;

import com.gymbuddy.InstaApi.entitys.errorLog;
import com.gymbuddy.InstaApi.repository.errorLogRepo;
import com.gymbuddy.InstaApi.services.errorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandeler extends ResponseEntityExceptionHandler {

    @Autowired
    private errorLogService service;

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(LocalDateTime.now(),
                                ex.getMessage(),
                                request.getDescription(false));
        errorLog log = new errorLog(LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false),
                request.getHeader("User-Agent"));
        service.errorLogSubmit(log);
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
