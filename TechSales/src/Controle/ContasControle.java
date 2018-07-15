/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ContasBEAN;
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
public class ContasControle {
    
     EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(ContasBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<ContasBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from ContasBEAN");
        ArrayList<ContasBEAN> catList = (ArrayList<ContasBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return catList;
    }

    public ContasBEAN localizar(int a) {
        ContasBEAN c = manager.find(ContasBEAN.class, a);
        return c;
    }

    public boolean editar(ContasBEAN a) {
        try {
            começar();
            tx.commit();
            // fechar();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public boolean remover(int c) {
        try {
            começar();
            ContasBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
