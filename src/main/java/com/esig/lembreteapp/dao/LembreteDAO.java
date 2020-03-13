/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esig.lembreteapp.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.esig.lembreteapp.model.Lembrete;

/**
 *
 * @author heitor
 */
public class LembreteDAO {

    private static LembreteDAO instance;
    private EntityManager entityManager = null;// =  emf.createEntityManager();
    private EntityManagerFactory emf = null;// = Persistence.createEntityManagerFactory("punit");

    public LembreteDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("punit");
        }

        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }

    public static LembreteDAO getInstance() {
        if (instance == null) {
            instance = new LembreteDAO();
        }

        return instance;
    }

    public void adicionarLembrete(Lembrete lembrete) {
        if (entityManager == null) {
            return;
        }

        try {
            System.out.println("Inserindo lembrete " + lembrete.getTexto());
            entityManager.getTransaction().begin();
            entityManager.persist(lembrete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            //obtem excessão quando inserido mesma chave
            entityManager.getTransaction().rollback();
            System.err.print("erro: ");
            System.err.println(ex);
        }
    }

    public List<Lembrete> listarLembretes() {
        try {
            entityManager.getTransaction().begin();
            List<Lembrete> result = entityManager.createQuery("select l from Lembrete l", Lembrete.class).getResultList();
            //entityManager.createQuery("select l from lembretes e where = :status",
            //Module.class).setParameter("status", status).getResultList();
            for (Lembrete l : result) {
                System.out.println("Lembrete (" + l.getTexto() + ")");
            }
            entityManager.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void excluirLembrete(Lembrete lembrete) {
        if (entityManager == null) {
            return;
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.remove(lembrete);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            //obtem excessão quando inserido mesma chave
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
    
    public void atualizarLembrete(Lembrete lembrete)
    {
        try
        {
            entityManager.getTransaction().begin();
            entityManager.merge(lembrete);
            entityManager.getTransaction().commit();
        }
        catch (Exception ex) {
            //obtem excessão quando inserido mesma chave
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
}
