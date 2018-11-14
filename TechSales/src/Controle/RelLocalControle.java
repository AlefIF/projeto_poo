/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.LocalRelatoriosBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;
import org.hibernate.HibernateException;

/**
 *
 * @author Alef
 */
public class RelLocalControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(LocalRelatoriosBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<LocalRelatoriosBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from LocalRelatoriosBEAN");
        ArrayList<LocalRelatoriosBEAN> caixaList = (ArrayList<LocalRelatoriosBEAN>) q.getResultList();
        tx.commit();
        return caixaList;
    }

    public LocalRelatoriosBEAN localizar(int a) {
        LocalRelatoriosBEAN c = manager.find(LocalRelatoriosBEAN.class, a);
        return c;
    }

    public boolean editar(LocalRelatoriosBEAN c) {

        try {
            começar();
            tx.commit();
            return true;
        } catch (HibernateException e) {
            return false;
        }

    }

    public boolean remover(int c) {

        try {
            começar();
            LocalRelatoriosBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
