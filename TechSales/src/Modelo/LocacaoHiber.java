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

    public static ArrayList<LocacaoBEAN> listarLoc() {
        começar();
        Query q = manager.createQuery("from locacao");
        ArrayList<LocacaoBEAN> locList = (ArrayList<LocacaoBEAN>) q.getResultList();
        tx.commit();
        fechar();
        return locList;
    }

    public static void cadLoc(LocacaoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        fechar();
    }

    public static void deleteLoc(LocacaoBEAN c) {
        começar();
        manager.remove(c);
        tx.commit();
        fechar();
    }

    public static void editarLoc(LocacaoBEAN c) {
        começar();
        manager.flush();
        tx.commit();
        fechar();
    }

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

}
