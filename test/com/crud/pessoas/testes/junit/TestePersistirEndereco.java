/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.pessoas.testes.junit;

import com.crud.pessoas.jpa.EntitymanagerUtil;
import com.crud.pessoas.modelo.Endereco;
import com.crud.pessoas.modelo.Pessoa;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;

/**
 *
 * @author Leandro
 */
public class TestePersistirEndereco {

    EntityManager em = EntitymanagerUtil.getEntityManager();

    public TestePersistirEndereco() {
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        boolean exception = false;

        try {
            Pessoa p = em.find(Pessoa.class, 2);
            Endereco e = new Endereco();
            e.setEstado("RS");
            e.setCep("99010290");
            e.setCidade("Passo Fundo");
            e.setLogradouro("Rua Lava Pés");
            e.setNumero(2398);
            p.adicionarEndereco(e);
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }

        Assert.assertEquals(false, exception);
    }
}
