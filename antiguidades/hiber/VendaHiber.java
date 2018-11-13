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
public class VendaHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<VendaBEAN> listarVen() {
        começar();
        Query q = manager.createQuery("from VendaBEAN");
        ArrayList<VendaBEAN> venList = (ArrayList<VendaBEAN>) q.getResultList();
        tx.commit();
        return venList;
    }

    public int cadVen(VendaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        return c.getVenCodigo();
    }

    public boolean deleteVen(int c) {
        try {
            começar();
            VendaBEAN a = listarPorCod(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarVen(VendaBEAN c) {
        try {
            começar();
            manager.flush();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public VendaBEAN listarPorCod(int c) {
        VendaBEAN a = manager.find(VendaBEAN.class, c);
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
