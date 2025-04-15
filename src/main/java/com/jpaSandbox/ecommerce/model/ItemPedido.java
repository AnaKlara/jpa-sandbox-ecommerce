package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@IdClass(ItemPedidoId.class)
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "produto_id")
    private Integer produtoId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", insertable = false, updatable = false)
    private Produto produto;

    @Column(name = "preco_produto")
    private BigDecimal precoProduto;

    private Integer quantidade;

    private Long versao;
}
