/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.pessoas.testes.junit;

import com.crud.pessoas.jpa.EntitymanagerUtil;
import com.crud.pessoas.modelo.Pessoa;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;

/**
 *
 * @author Leandro
 */
public class TestePersistirPessoa {

    EntityManager em = EntitymanagerUtil.getEntityManager();

    public TestePersistirPessoa() {
    }

    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void teste() {
        boolean exception = false;

        try {
            Pessoa p = new Pessoa();
            p.setNome("Leandro CR");
            p.setSexo("M");
            p.setIdade(new GregorianCalendar(1988, Calendar.APRIL, 3));
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
