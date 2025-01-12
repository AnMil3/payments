package mk.iwec.payments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleCustomException(Exception e, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
        exceptionResponse.setMessage(e.getLocalizedMessage());
        exceptionResponse.setTimestamp(new Date());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

}
