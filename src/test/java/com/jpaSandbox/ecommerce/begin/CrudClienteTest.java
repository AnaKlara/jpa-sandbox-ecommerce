package com.jpaSandbox.ecommerce.begin;

import com.jpaSandbox.ecommerce.EntityManagerTest;
import com.jpaSandbox.ecommerce.model.Cliente;
import com.jpaSandbox.ecommerce.model.Produto;
import com.jpaSandbox.ecommerce.model.SexoCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrudClienteTest extends EntityManagerTest {

    @Test
    public void inserirRegistro() {
        Cliente cliente = new Cliente();

//        cliente.setId(3);
        cliente.setNome("José Lucas");
        cliente.setSexo(SexoCliente.MASCULINO);
        cliente.setCpf("333");

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertNotNull(clienteVerificacao);
    }

    @Test
    public void busarPorIdentificador() {
        Produto produto = entityManager.find(Produto.class, 1);

        Assertions.assertNotNull(produto);
        Assertions.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizarRegistro() {
        Cliente cliente = new Cliente();

        cliente.setId(1);
        cliente.setNome("Fernando Medeiros Silva");
        cliente.setCpf("000");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertEquals("Fernando Medeiros Silva", clienteVerificacao.getNome());
    }

    @Test
    public void removerRegistro() {
        Cliente cliente = entityManager.find(Cliente.class, 2);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertNull(clienteVerificacao);
    }
}
