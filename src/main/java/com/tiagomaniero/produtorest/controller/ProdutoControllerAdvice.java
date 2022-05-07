package com.tiagomaniero.produtorest.controller;

import com.tiagomaniero.produtorest.exception.ProductNotFoundException;
import com.tiagomaniero.produtorest.exception.ProductNullException;
import com.tiagomaniero.produtorest.exception.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<?> capturarErrorNull(){
        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message","Verifique os campos do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<?> capturaErroPreco(){
        Map<String,Object> body = new HashMap<String, Object>();

        body.put("message", "Verifique o preço do produto");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> capturarProdutoNaoEncontrado(){
        Map<String,Object> body = new HashMap<String, Object>();

        body.put("message", "Produto não encontrado");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
