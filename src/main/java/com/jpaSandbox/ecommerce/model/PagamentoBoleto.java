package com.jpaSandbox.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PagamentoBoleto {

    private LocalDate dataVenciemnto;

    private String codigoBarras;
}
