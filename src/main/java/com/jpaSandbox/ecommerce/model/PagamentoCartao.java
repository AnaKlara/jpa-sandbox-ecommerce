package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "pedido_id") // já que o relacionamento é 1:1 a entidade pode ter o mesmo ID
    private Integer id;

    @Column(name = "numero_cartao")
    private String numeroCartao;

    @MapsId
    @OneToOne
    @JoinColumn(name = "pedido_id") // Esta classe tem o atributo que faz dela o owner do relacionamento
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
}
