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
    @Column(name = "pedido_id") // já que o relacionamento é 1:1 a entidade pode ter o mesmo ID
    private Integer id;

    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;

    @MapsId // já vem com o insertable e o updatable
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id") // Esta classe tem o atributo que faz dela o owner do relacionamento
    private Pedido pedido;

    private Integer versao;
}
