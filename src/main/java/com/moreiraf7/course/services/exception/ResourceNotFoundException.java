package com.moreiraf7.course.services.exception;

public class ResourceNotFoundException extends RuntimeException {

    /*
    * Exception para tratar o objeto não encontrado.
    * Recebe um id e retorna uma mensagem dizendo que o id recebido não foi encontrado
    */
    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }
}
