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
public class ConsoleHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static ArrayList<ConsoleBEAN> listarCon() {
        começar();
        Query q = manager.createQuery("from console");
        ArrayList<ConsoleBEAN> conList = (ArrayList<ConsoleBEAN>) q.getResultList();
        tx.commit();
        fechar();
        return conList;
    }

    public static void cadCon(ConsoleBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        fechar();
    }

    public static void deleteCon(ConsoleBEAN c) {
        começar();
        manager.remove(c);
        tx.commit();
        fechar();
    }

    public static void editarCon(ConsoleBEAN c) {
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
