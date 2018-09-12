/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.LucroBEAN;
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
public class LucroControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(LucroBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<LucroBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from LucroBEAN");
        ArrayList<LucroBEAN> lucList = (ArrayList<LucroBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return lucList;
    }

    public LucroBEAN localizar(int a) {
        LucroBEAN c = manager.find(LucroBEAN.class, a);
        return c;
    }

    public boolean editar(LucroBEAN a) {
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
            LucroBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
