/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import jpa.JpaUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.hibernate.HibernateException;

/**
 *
 * @author Alef
 */
public class CategoriaHiber {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public ArrayList<CategoriaBEAN> listarCat() {
        começar();
        Query q = manager.createQuery("from CategoriaBEAN");
        ArrayList<CategoriaBEAN> catList = (ArrayList<CategoriaBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return catList;
    }

    public void cadCat(CategoriaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        //fechar();
    }

    public boolean deleteCat(int c) {
        try {
            começar();
            CategoriaBEAN a = listarPorCod(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarCat(CategoriaBEAN c) {
        try {
            começar();
            tx.commit();
            // fechar();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public CategoriaBEAN listarPorCod(int c) {
        CategoriaBEAN a = manager.find(CategoriaBEAN.class, c);
        return a;
    }

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

}
