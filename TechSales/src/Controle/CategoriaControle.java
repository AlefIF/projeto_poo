/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.CategoriaBEAN;
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
public class CategoriaControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(CategoriaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<CategoriaBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from CategoriaBEAN");
        ArrayList<CategoriaBEAN> catList = (ArrayList<CategoriaBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return catList;
    }

    public CategoriaBEAN localizar(int a) {
        CategoriaBEAN c = manager.find(CategoriaBEAN.class, a);
        return c;
    }

    public boolean editar(CategoriaBEAN a) {
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
            CategoriaBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
