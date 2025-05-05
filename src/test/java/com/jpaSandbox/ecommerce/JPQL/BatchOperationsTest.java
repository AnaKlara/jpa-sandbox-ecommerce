package com.jpaSandbox.ecommerce.JPQL;

import com.jpaSandbox.ecommerce.EntityManagerTest;
import com.jpaSandbox.ecommerce.model.Produto;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class BatchOperationsTest extends EntityManagerTest {

    private static final int INSERT_LIMIT = 4;

    @Test
    public void removerEmLote() {
        entityManager.getTransaction().begin();

        String jpql = "delete from Produto p where p.id between 8 and 12";

        Query query = entityManager.createQuery(jpql);
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }

    @Test
    public void atualizarEmLote() {
        entityManager.getTransaction().begin();

        String jpql = "update Produto p set p.preco = p.preco + (p.preco * :valor) " +
                " where exists (select 1 from p.categorias c2 where c2.id = :categoria)";

        Query query = entityManager.createQuery(jpql);
        query.setParameter("categoria", 2);
        query.setParameter("valor", new BigDecimal("0.1"));
        query.executeUpdate();

        entityManager.getTransaction().commit();
    }

    @Test
    public void inserirEmLote() throws IOException {
        InputStream in = BatchOperationsTest.class.getClassLoader()
                .getResourceAsStream("produtos/import.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        entityManager.getTransaction().begin();

        int contadorInsercoes = 0;

        for(String linha: reader.lines().collect(Collectors.toList())) {
            if (linha.isBlank()) {
                continue;
            }

            String[] produtoColuna = linha.split(";");
            Produto produto = new Produto();
            produto.setNome(produtoColuna[0]);
            produto.setDescricao(produtoColuna[1]);
            produto.setPreco(new BigDecimal(produtoColuna[2]));
            produto.setDataCriacao(LocalDateTime.now());

            entityManager.persist(produto);

            if (++contadorInsercoes == INSERT_LIMIT ) {
                entityManager.flush();
                entityManager.clear();

                contadorInsercoes = 0;

                System.out.println("---------------------------------");
            }
        }

        entityManager.getTransaction().commit();
    }
}
