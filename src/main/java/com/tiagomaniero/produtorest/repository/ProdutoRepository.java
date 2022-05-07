package com.tiagomaniero.produtorest.repository;

import com.tiagomaniero.produtorest.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
