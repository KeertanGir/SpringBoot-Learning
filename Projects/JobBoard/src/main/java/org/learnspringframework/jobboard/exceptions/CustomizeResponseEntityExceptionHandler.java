package org.learnspringframework.jobboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<ErrorDetailsPojo> HandleAllExceptions(Exception ex, WebRequest request) throws Exception{
        ErrorDetailsPojo errorDetailsPojo = new ErrorDetailsPojo(HttpStatus.INTERNAL_SERVER_ERROR.value() ,ex.getMessage(), LocalDate.now(), request.getDescription(false));
        return new ResponseEntity<ErrorDetailsPojo>( errorDetailsPojo ,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = JobNotFoundException.class)
    public final ResponseEntity<ErrorDetailsPojo> HandleJobNotFoundException(Exception ex, WebRequest request ) throws Exception{
        ErrorDetailsPojo errorDetailsPojo = new ErrorDetailsPojo( HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDate.now(), request.getDescription(false) );
        return new ResponseEntity<ErrorDetailsPojo>( errorDetailsPojo, HttpStatus.NOT_FOUND );
    }

    @ExceptionHandler(value = InvalidJobDataException.class)
    public final ResponseEntity<ErrorDetailsPojo> HandleInvalidJobDataException(Exception ex, WebRequest request) throws Exception{
        ErrorDetailsPojo errorDetailsPojo = new ErrorDetailsPojo(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), LocalDate.now(), request.getDescription(false) );
        return new ResponseEntity<ErrorDetailsPojo>(errorDetailsPojo, HttpStatus.BAD_REQUEST );
    }

}
