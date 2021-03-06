/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.CaixaBEAN;
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
public class CaixaControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(CaixaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<CaixaBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from CaixaBEAN");
        ArrayList<CaixaBEAN> caixaList = (ArrayList<CaixaBEAN>) q.getResultList();
        tx.commit();
        return caixaList;
    }

    public CaixaBEAN localizar(int a) {

        CaixaBEAN c = manager.find(CaixaBEAN.class, a);
        return c;
    }

    public boolean editar(CaixaBEAN c) {

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
            CaixaBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
