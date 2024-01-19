package com.comejia.di.factura.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

    private Product product;
    private Integer quantity;

    public Integer getImporte() {
        return quantity * product.getPrice();
    }
}
