package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estoque")
@Getter
@Setter
public class Estoque extends EntidadeBaseInteger{

    @OneToOne(optional = false)
    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_estoque_produto"))
    private Produto produto;

    private Long quantidade;

    private Long versao;
}
