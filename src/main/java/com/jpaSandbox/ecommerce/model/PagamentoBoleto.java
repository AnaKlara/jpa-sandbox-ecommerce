package com.jpaSandbox.ecommerce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
//@DiscriminatorValue("boleto")
@Table(name = "pagamento_boleto")
public class PagamentoBoleto extends Pagamento {

    @Column(name = "data_vencimento")
    private LocalDate dataVenciemnto;

    @Column(name = "codigo_barras")
    private String codigoBarras;
}
