package com.jpaSandbox.ecommerce.advancedMapping;

import com.jpaSandbox.ecommerce.EntityManagerTest;
import com.jpaSandbox.ecommerce.model.NotaFiscal;
import com.jpaSandbox.ecommerce.model.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

public class SavingFilesTest  extends EntityManagerTest {

    @Test
    public void salvarXmlNota() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setXml(carregarNotaFiscal());

        entityManager.getTransaction().begin();
        entityManager.persist(notaFiscal);
        entityManager.getTransaction().commit();

        NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class, notaFiscal.getId());
        Assertions.assertNotNull(notaFiscalVerificacao.getXml());
        Assertions.assertTrue(notaFiscalVerificacao.getXml().length > 0);

        /*
        try {
            OutputStream out = new FileOutputStream(
                    Files.createFile(Paths.get(
                            System.getProperty("user.home") + "/xml.xml")).toFile());
            out.write(notaFiscalVerificacao.getXml());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        */
    }

    private static byte[] carregarNotaFiscal() {
        try {
            return SavingFilesTest.class.getResourceAsStream(
                    "/nota-fiscal.xml").readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
