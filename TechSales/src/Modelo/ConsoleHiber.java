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
        Query q = manager.createQuery("from ConsoleBEAN");
        ArrayList<ConsoleBEAN> conList = (ArrayList<ConsoleBEAN>) q.getResultList();
        tx.commit();
        return conList;
    }

    public void cadCon(ConsoleBEAN c) {
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteCon(int c) {
        try {
            ConsoleBEAN a = manager.find(ConsoleBEAN.class, c);
            manager.remove(a);
            fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarCon(ConsoleBEAN c) {
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
