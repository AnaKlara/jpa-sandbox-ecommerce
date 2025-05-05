package com.jpaSandbox.ecommerce.JPQL;

import com.jpaSandbox.ecommerce.EntityManagerTest;
import com.jpaSandbox.ecommerce.model.Produto;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DynamicQueryTest extends EntityManagerTest {
    @Test
    public void executarConsultaDinamica() {
        Produto consultado = new Produto();
        consultado.setNome("Câmera GoPro");

        List<Produto> lista = pesquisar(consultado);

        Assertions.assertFalse(lista.isEmpty());
        Assertions.assertEquals("Câmera GoPro Hero 7", lista.get(0).getNome());
    }

    private List<Produto> pesquisar(Produto consultado) {
        StringBuilder jpql = new StringBuilder("select p from Produto p where 1 = 1");

        if (consultado.getNome() != null) {
            jpql.append(" and p.nome like concat('%', :nome, '%')");
        }

        if (consultado.getDescricao() != null) {
            jpql.append(" and p.descricao like concat('%', :descricao, '%')");
        }

        TypedQuery<Produto> typedQuery = entityManager.createQuery(jpql.toString(), Produto.class);

        if (consultado.getNome() != null) {
            typedQuery.setParameter("nome", consultado.getNome());
        }

        if (consultado.getDescricao() != null) {
            typedQuery.setParameter("descricao", consultado.getDescricao());
        }

        return typedQuery.getResultList();
    }
}
