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
public class LocacaoHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<LocacaoBEAN> listarLoc() {
        Query q = manager.createQuery("from LocacaoBEAN");
        ArrayList<LocacaoBEAN> locList = (ArrayList<LocacaoBEAN>) q.getResultList();
        tx.commit();
        return locList;
    }

    public void cadLoc(LocacaoBEAN c) {
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteLoc(int c) {
        try {
            LocacaoBEAN a = manager.find(LocacaoBEAN.class, c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarLoc(LocacaoBEAN c) {
        try {
            manager.flush();
            tx.commit();
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
