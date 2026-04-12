package com.gui.produtosAPI.Service;

import com.gui.produtosAPI.Entity.Produto;
import com.gui.produtosAPI.Repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public List<Produto> listProducts(){
        return produtoRepository.findAll();
    }

    @Transactional
    public Optional<Produto> findProductBySku(String sku){
        Optional<Produto> produto = produtoRepository.findBySku(sku);

        if (produto.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado");
        }
        return produto;
    }

    public Produto createProduct(String name, String sku, BigDecimal preco){

        if (produtoRepository.existsBySku(sku)){
            throw new IllegalArgumentException("SKU já existente");
        }

        Produto produto = new Produto(name,sku, preco);
        return produtoRepository.save(produto);
    }

}
