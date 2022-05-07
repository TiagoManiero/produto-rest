package com.tiagomaniero.produtorest.service;

import com.tiagomaniero.produtorest.exception.ProductNotFoundException;
import com.tiagomaniero.produtorest.exception.ProductNullException;
import com.tiagomaniero.produtorest.exception.ProductPriceException;
import com.tiagomaniero.produtorest.model.Produto;
import com.tiagomaniero.produtorest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto) throws Exception{
        if (produto.getNome() == null || produto.getPreco() == null)
            throw new ProductNullException();

        if (produto.getPreco() < 0)
            throw new ProductPriceException();

        return repository.save(produto);
    }

    public Produto findById(Long id) throws ProductNotFoundException {
        Optional<Produto> produto = repository.findById(id);

        if(!produto.isPresent()){
            throw new ProductNotFoundException();
        }

        return produto.get();
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }
}
