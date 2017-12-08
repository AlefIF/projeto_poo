/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.bdii.TechSales.JpaUtil.JpaUtil;
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
        Query q = manager.createQuery("from venda");
        ArrayList<VendaBEAN> venList = (ArrayList<VendaBEAN>) q.getResultList();
        tx.commit();
        fechar();
        return venList;
    }

    public int cadVen(VendaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        fechar();
        return c.getVenCodigo();
    }

    public boolean deleteVen(int c) {
        try {
            começar();
            VendaBEAN a = manager.find(VendaBEAN.class, c);
            manager.remove(a);
            tx.commit();
            fechar();
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
            fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

}
