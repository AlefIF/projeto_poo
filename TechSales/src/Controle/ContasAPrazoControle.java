/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.contasAPrazoBEAN;
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

    public void cadastrar(contasAPrazoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<contasAPrazoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from contasAPrazoBEAN");
        ArrayList<contasAPrazoBEAN> capList = (ArrayList<contasAPrazoBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return capList;
    }

    public contasAPrazoBEAN localizar(int a) {
        contasAPrazoBEAN c = manager.find(contasAPrazoBEAN.class, a);
        return c;
    }

    public boolean editar(contasAPrazoBEAN a) {
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
            contasAPrazoBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
