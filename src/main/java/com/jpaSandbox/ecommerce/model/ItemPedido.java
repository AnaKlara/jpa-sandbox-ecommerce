package com.jpaSandbox.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ItemPedido {

    private BigDecimal precoProduto;

    private Integer quantidade;

    private Long versao;
}
