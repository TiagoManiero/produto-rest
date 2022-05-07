package com.tiagomaniero.produtorest;

import com.tiagomaniero.produtorest.exception.ProductPriceException;
import com.tiagomaniero.produtorest.model.Produto;
import com.tiagomaniero.produtorest.service.ProdutoService;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void vericicaValorNegativoNoProduto() {
        Produto produto = new Produto();

        produto.setNome("Teste");
        produto.setPreco(-10.0);

        assertThrows(ProductPriceException.class, () -> produtoService.save(produto));

    }
}
