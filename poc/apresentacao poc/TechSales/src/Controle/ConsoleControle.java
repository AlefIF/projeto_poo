/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ConsoleBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;
import org.hibernate.HibernateException;

/**
 *
 * @author admin
 */
public class ConsoleControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(ConsoleBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<ConsoleBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from ConsoleBEAN");
        ArrayList<ConsoleBEAN> conList = (ArrayList<ConsoleBEAN>) q.getResultList();
        tx.commit();
        return conList;
    }

    public ConsoleBEAN localizar(int a) {

        ConsoleBEAN b = manager.find(ConsoleBEAN.class, a);
        return b;
    }

    public boolean editar(ConsoleBEAN c) {

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
            ConsoleBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
