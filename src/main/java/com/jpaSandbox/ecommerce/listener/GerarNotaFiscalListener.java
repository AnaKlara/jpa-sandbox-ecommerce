package com.jpaSandbox.ecommerce.listener;

import com.jpaSandbox.ecommerce.model.Pedido;
import com.jpaSandbox.ecommerce.service.NotaFiscalService;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class GerarNotaFiscalListener {

    private NotaFiscalService notaFiscalService = new NotaFiscalService();

    @PrePersist
    @PreUpdate
    public void gerar(Pedido pedido) {
        if (pedido.isPago() && pedido.getNotaFiscal() == null) {
            notaFiscalService.gerar(pedido);
        }
    }
}