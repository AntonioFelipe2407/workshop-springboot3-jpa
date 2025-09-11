package com.moreiraf7.course.resources.exceptions;

import com.moreiraf7.course.services.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice //Pega as exceção que acontecerem para que a classe possa tratar
public class ResourceExceptionHandler {

    /*
    * Classe responsável pelo tratamento manual dos erros.
    */

    //Metodo que retorna a requisição com o erro ResourceNotFoundException tratado.
    //Anotation pega toda a exceção desse tipo que acontecer para que seja tratada
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";  // Mensagem basica do erro
        HttpStatus status = HttpStatus.NOT_FOUND;  // Status 404
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
