/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ContasAPrazoBEAN;
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
public class ContasAPrazoControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(ContasAPrazoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<ContasAPrazoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from ContasAPrazoBEAN");
        ArrayList<ContasAPrazoBEAN> capList = (ArrayList<ContasAPrazoBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return capList;
    }

    public ContasAPrazoBEAN localizar(int a) {
        ContasAPrazoBEAN c = manager.find(ContasAPrazoBEAN.class, a);
        return c;
    }

    public boolean editar(ContasAPrazoBEAN a) {
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
            ContasAPrazoBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
