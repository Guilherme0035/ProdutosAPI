package com.gui.produtosAPI.Repository;

import com.gui.produtosAPI.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,String> {

    Optional<Produto> findBySku(String sku);
    boolean existsBySku(String sku);
}
