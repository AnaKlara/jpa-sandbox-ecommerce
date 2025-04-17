package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "nota_fiscal")
public class NotaFiscal extends EntidadeBaseInteger{

    @Lob // https://docs.jboss.org/hibernate/orm/6.0/userguide/html_single/Hibernate_User_Guide.html#basic-bytearray
    @Column(length = 1000, nullable = false)
    private byte[] xml;

    @Column(name = "data_emissao", nullable = false)
    private Date dataEmissao;

    @MapsId // já vem com o insertable e o updatable
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id", nullable = false, foreignKey = @ForeignKey(name = "fk_nota_fiscal_pedido")) // Esta classe tem o atributo que faz dela o owner do relacionamento
    private Pedido pedido;

    private Integer versao;
}
