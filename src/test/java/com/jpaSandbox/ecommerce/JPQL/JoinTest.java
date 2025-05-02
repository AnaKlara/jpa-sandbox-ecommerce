package com.jpaSandbox.ecommerce.JPQL;

import com.jpaSandbox.ecommerce.EntityManagerTest;
import com.jpaSandbox.ecommerce.model.Pedido;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JoinTest extends EntityManagerTest {

    @Test
    public void usarJoinFetch() {
        String jpql = "select p from Pedido p "
                + " left join fetch p.pagamento "
                + " join fetch p.cliente "
                + " left join fetch p.notaFiscal "
                ;

        TypedQuery<Pedido> typedQuery = entityManager.createQuery(jpql, Pedido.class);

        List<Pedido> lista = typedQuery.getResultList();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void fazerLeftJoin() {
        String jpql = "select p from Pedido p left join p.pagamento pag on pag.status = 'PROCESSANDO'";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assertions.assertFalse(lista.isEmpty());
    }

    @Test
    public void fazerJoin() {
        String jpql = "select p from Pedido p join p.pagamento pag";

        TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> lista = typedQuery.getResultList();
        Assertions.assertTrue(lista.size() == 1);
    }
}
