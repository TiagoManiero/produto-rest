package com.tiagomaniero.produtorest.controller;

import com.tiagomaniero.produtorest.exception.PedidoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class PedidoControllerAdvice {

    @ExceptionHandler(PedidoNotFoundException.class)
    public ResponseEntity<?> capturarErrorPedidoNotFound(){
        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message","Pedido não existe");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
