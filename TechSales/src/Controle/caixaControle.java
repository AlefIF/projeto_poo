/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import Modelo.caixaBEAN;
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
public class caixaControle {
    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(caixaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<caixaBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from CaixaBEAN");
        ArrayList<caixaBEAN> caixaList = (ArrayList<caixaBEAN>) q.getResultList();
        tx.commit();
        return caixaList;
    }

    public caixaBEAN localizar(int a) {

        caixaBEAN c = manager.find(caixaBEAN.class, a);
        return c;
    }

    public boolean editar(caixaBEAN c) {

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
            caixaBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    
}
