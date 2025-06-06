package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("cartao")
@Entity
public class PagamentoCartao extends Pagamento {

    @Column(name = "numero_cartao", length = 50)
    private String numeroCartao;
}
