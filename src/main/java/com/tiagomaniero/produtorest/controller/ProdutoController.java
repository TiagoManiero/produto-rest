package com.tiagomaniero.produtorest.controller;

import com.tiagomaniero.produtorest.exception.ProductNotFoundException;
import com.tiagomaniero.produtorest.model.Produto;
import com.tiagomaniero.produtorest.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {
        produto = service.save(produto);

        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable(value = "id") Long id) throws ProductNotFoundException {
        Produto produto = service.findById(id);

        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos() {

        List<Produto> produtos = service.findAll();

        return ResponseEntity.ok().body(produtos);

    }

}
