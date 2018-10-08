/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.VendedorBEAN;
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
public class VendedorControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(VendedorBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<VendedorBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from VendedorBEAN");
        ArrayList<VendedorBEAN> catList = (ArrayList<VendedorBEAN>) q.getResultList();
        tx.commit();
        return catList;
    }

    public VendedorBEAN localizar(int a) {
        VendedorBEAN c = manager.find(VendedorBEAN.class, a);
        return c;
    }

    public boolean editar(VendedorBEAN a) {
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
            VendedorBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
   
}
