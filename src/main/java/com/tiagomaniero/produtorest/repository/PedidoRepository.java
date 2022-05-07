package com.tiagomaniero.produtorest.repository;

import com.tiagomaniero.produtorest.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
