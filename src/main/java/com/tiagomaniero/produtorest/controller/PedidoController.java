package com.tiagomaniero.produtorest.controller;

import com.tiagomaniero.produtorest.exception.PedidoNotFoundException;
import com.tiagomaniero.produtorest.model.Pedido;
import com.tiagomaniero.produtorest.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping
    public ResponseEntity<Pedido> salvarProduto(@RequestBody Pedido pedido){
        pedido = service.save(pedido);

        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Pedido> buscaPedido(@PathVariable(value = "id") Long id) throws PedidoNotFoundException {
        Pedido pedido = service.findById(id);

        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping("/busca-todos")
    public ResponseEntity<?> buscaTodosProdutos(){
        List<Pedido> pedidos = service.findAll();

        return ResponseEntity.ok().body(pedidos);
    }
}
