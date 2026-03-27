package com.gui.produtosAPI.Controller;

import com.gui.produtosAPI.Entity.DTO.CreateProductRequest;
import com.gui.produtosAPI.Entity.Produto;
import com.gui.produtosAPI.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/api/products")
    ResponseEntity<List<Produto>> listProducts(){
        List<Produto> allProducts = produtoService.listProducts();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping("/api/products")
    ResponseEntity<Produto> createProduct(@RequestBody CreateProductRequest request){
        Produto prod = produtoService.createProduct(request.name(), request.sku(), request.preco());
        return ResponseEntity.ok(prod);
    }
}
