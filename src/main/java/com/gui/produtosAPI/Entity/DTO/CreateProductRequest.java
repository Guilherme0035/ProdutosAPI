package com.gui.produtosAPI.Entity.DTO;

import java.math.BigDecimal;

public record CreateProductRequest (String name, String sku, BigDecimal preco){
}
