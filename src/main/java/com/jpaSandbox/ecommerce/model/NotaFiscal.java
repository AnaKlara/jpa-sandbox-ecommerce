package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;

    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id") // Esta classe tem o atributo que faz dela o owner do relacionamento
    private Pedido pedido;

    private Integer versao;
}
