package com.jpaSandbox.ecommerce.discoveryEntityManager;

import com.jpaSandbox.ecommerce.EntityManagerTest;
import com.jpaSandbox.ecommerce.model.Produto;
import org.junit.jupiter.api.Test;

public class FirstLevelCacheTest extends EntityManagerTest {
    @Test
    public void verificarCache() {
        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.getNome());

        System.out.println("------------------------------");

//        entityManager.close();
//        entityManager = entityManagerFactory.createEntityManager();

        Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());
        System.out.println(produtoResgatado.getNome());
    }
}
