package com.projectRs.sgrs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

/*
 *   Esta clase maneja de forma global los errores de la aplicacion
 *    gracias a @ControllerAdvance, spring la detecta como un majador
 *    de excepciones para todos los controladores REST
 * */
@ControllerAdvice
public class ErrorHandlerController {

    /*
    *   Este metodo se ejecuta automaticamente cuando se lanza una
    *   excepcion de tipo IlegalArgumentException en cualquier parte
    *   de los controladores
    * */
    @ExceptionHandler(value = IllegalArgumentException.class)
    private ResponseEntity<HashMap<String, Object>> IlegalArgumentHandler(IllegalArgumentException ex){
        //Se contruye la respuesta en forma de mapa (key-value)
        final var response = new HashMap<String, Object>();
        response.put("code", HttpStatus.BAD_REQUEST.value());
        response.put("status", HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.put("message", ex.getMessage());
        //Se devuelve la respuesta con el estado 400 y el Json en el body
        return ResponseEntity.badRequest().body(response);

    }
}
