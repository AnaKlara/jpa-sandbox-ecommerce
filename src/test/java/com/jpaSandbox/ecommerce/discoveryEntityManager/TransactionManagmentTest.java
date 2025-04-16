package com.jpaSandbox.ecommerce.discoveryEntityManager;

import com.jpaSandbox.ecommerce.EntityManagerTest;
import com.jpaSandbox.ecommerce.model.Pedido;
import com.jpaSandbox.ecommerce.model.StatusPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransactionManagmentTest extends EntityManagerTest {
    @Test
    public void abrirFecharCancelarTransacao() {
        Assertions.assertThrows(Exception.class, () -> erroEsperadoMetodoDeNegocio());
    }

    private void erroEsperadoMetodoDeNegocio() {
        try {
            entityManager.getTransaction().begin();
            metodoDeNegocio();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    private void metodoDeNegocio() {
        Pedido pedido = entityManager.find(Pedido.class, 1);
        pedido.setStatus(StatusPedido.PAGO);

        if (pedido.getPagamento() == null) {
            throw new RuntimeException("Pedido ainda não foi pago.");
        }
    }
}
