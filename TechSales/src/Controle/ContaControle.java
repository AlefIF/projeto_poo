/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ContaBEAN;
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
public class ContaControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(ContaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<ContaBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from ContaBEAN");
        ArrayList<ContaBEAN> catList = (ArrayList<ContaBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return catList;
    }

    public ContaBEAN localizar(int a) {
        ContaBEAN c = manager.find(ContaBEAN.class, a);
        return c;
    }

    public boolean editar(ContaBEAN a) {
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
            ContaBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
