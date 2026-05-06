package com.gui.produtosAPI.Controller.Exception;

import com.gui.produtosAPI.Service.Execption.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceNotFoundExecptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<StandarError> resourceNotFoundProduct (ResourceNotFoundException exception, HttpServletRequest request){
        String error = "SKU inválido";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(Instant.now(), request.getRequestURI(), exception.getMessage(), error,status.value());
        return ResponseEntity.status(status).body(err);
    }
}
