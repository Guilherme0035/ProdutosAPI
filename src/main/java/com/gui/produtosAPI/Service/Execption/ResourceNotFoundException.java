package com.gui.produtosAPI.Service.Execption;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long seriserialVersionUID = 1L;

    public ResourceNotFoundException(String sku){
        super(sku);
    }
}
