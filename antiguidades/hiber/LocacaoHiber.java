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

/**
 *
 * @author Alef
 */
public class LocacaoHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<LocacaoBEAN> listarLoc() {
        começar();
        Query q = manager.createQuery("from LocacaoBEAN");
        ArrayList<LocacaoBEAN> locList = (ArrayList<LocacaoBEAN>) q.getResultList();
        tx.commit();
        return locList;
    }

    public void cadLoc(LocacaoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteLoc(int c) {
        try {
            começar();
            LocacaoBEAN a = listarPorCod(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarLoc(LocacaoBEAN c) {
        try {
            começar();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public LocacaoBEAN listarPorCod(int c) {
        LocacaoBEAN a = manager.find(LocacaoBEAN.class, c);
        return a;
    }

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

}
