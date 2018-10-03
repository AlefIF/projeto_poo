/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ContaAPrazoBEAN;
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
public class ContaAPrazoControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(ContaAPrazoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<ContaAPrazoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from ContaAPrazoBEAN");
        ArrayList<ContaAPrazoBEAN> capList = (ArrayList<ContaAPrazoBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return capList;
    }

    public ContaAPrazoBEAN localizar(int a) {
        ContaAPrazoBEAN c = manager.find(ContaAPrazoBEAN.class, a);
        return c;
    }

    public boolean editar(ContaAPrazoBEAN a) {
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
            ContaAPrazoBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
