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
public class DevolucaoHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<DevolucaoBEAN> listarDev() {
        começar();
        Query q = manager.createQuery("from DevolucaoBEAN");
        ArrayList<DevolucaoBEAN> devList = (ArrayList<DevolucaoBEAN>) q.getResultList();
        tx.commit();
        return devList;
    }

    public void cadDev(DevolucaoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteDev(int c) {
        try {
            começar();
            DevolucaoBEAN a = listarPorCod(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarDev(DevolucaoBEAN c) {
        try {
            começar();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DevolucaoBEAN listarPorCod(int c) {
        DevolucaoBEAN a = manager.find(DevolucaoBEAN.class, c);
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
