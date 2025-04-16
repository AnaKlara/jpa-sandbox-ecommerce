package com.jpaSandbox.ecommerce.advancedMapping;

import com.jpaSandbox.ecommerce.EntityManagerTest;
import com.jpaSandbox.ecommerce.model.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransientPropertiesTest extends EntityManagerTest {


    @Test
    public void validarPrimeiroNome() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assertions.assertEquals("Fernando", cliente.getPrimeiroNome());
    }
}
