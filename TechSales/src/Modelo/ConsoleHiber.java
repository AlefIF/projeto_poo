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

    public ArrayList<ConsoleBEAN> listarCon() {
        começar();
        Query q = manager.createQuery("from console");
        ArrayList<ConsoleBEAN> conList = (ArrayList<ConsoleBEAN>) q.getResultList();
        tx.commit();
        fechar();
        return conList;
    }

    public void cadCon(ConsoleBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        fechar();
    }

    public boolean deleteCon(int c) {
        try {
            começar();
            ConsoleBEAN a = manager.find(ConsoleBEAN.class, c);
            manager.remove(a);
            tx.commit();
            fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarCon(ConsoleBEAN c) {
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
