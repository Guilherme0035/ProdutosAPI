package com.gui.produtosAPI.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Data
public class Produto {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sku;
    private BigDecimal preco;

    public Produto(String name, String sku, BigDecimal preco) {
        this.name = name;
        this.sku = sku;
        this.preco = preco;
    }
}
