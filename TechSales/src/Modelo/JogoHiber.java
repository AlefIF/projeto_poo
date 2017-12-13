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
public class JogoHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<JogoBEAN> listarJog() {
        Query q = manager.createQuery("from JogoBEAN");
        ArrayList<JogoBEAN> jogList = (ArrayList<JogoBEAN>) q.getResultList();
        tx.commit();
        return jogList;
    }

    public void cadJog(JogoBEAN c) {
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteJog(int c) {
        try {
            JogoBEAN a = manager.find(JogoBEAN.class, c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarJog(JogoBEAN c) {
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
