package com.tiagomaniero.produtorest.service;

import com.tiagomaniero.produtorest.exception.PedidoNotFoundException;
import com.tiagomaniero.produtorest.model.Pedido;
import com.tiagomaniero.produtorest.model.Produto;
import com.tiagomaniero.produtorest.repository.PedidoRepository;
import com.tiagomaniero.produtorest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido save(Pedido pedido) {
        Set<Produto> produtos = new HashSet<>();

        pedido.setDataPedido(LocalDateTime.now());
        pedido.getProdutos().forEach(produto -> {
            produtos.add(produtoRepository.getById(produto.getId()));
        });
        pedido.setProdutos(produtos);

        return repository.save(pedido);
    }

    public Pedido findById(Long id) throws PedidoNotFoundException {
        Optional<Pedido> pedido = repository.findById(id);
        if(!pedido.isPresent()){
            throw new PedidoNotFoundException();
        }
        
        return pedido.get();
    }

    public List<Pedido> findAll() {
        return repository.findAll();
    }
}
