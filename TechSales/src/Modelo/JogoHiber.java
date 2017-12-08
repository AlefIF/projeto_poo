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
        começar();
        Query q = manager.createQuery("from jogo");
        ArrayList<JogoBEAN> jogList = (ArrayList<JogoBEAN>) q.getResultList();
        tx.commit();
        fechar();
        return jogList;
    }

    public void cadJog(JogoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        fechar();
    }

    public boolean deleteJog(int c) {
        try {
            começar();
            JogoBEAN a = manager.find(JogoBEAN.class, c);
            manager.remove(a);
            tx.commit();
            fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarJog(JogoBEAN c) {
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
