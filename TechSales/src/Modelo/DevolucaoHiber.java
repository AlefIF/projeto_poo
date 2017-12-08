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
public class DevolucaoHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<DevolucaoBEAN> listarDev() {
        começar();
        Query q = manager.createQuery("from devolucao");
        ArrayList<DevolucaoBEAN> devList = (ArrayList<DevolucaoBEAN>) q.getResultList();
        tx.commit();
        fechar();
        return devList;
    }

    public void cadDev(DevolucaoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        fechar();
    }

    public boolean deleteDev(DevolucaoBEAN c) {
        try {
            começar();
            DevolucaoBEAN a = manager.find(DevolucaoBEAN.class, c);
            manager.remove(a);
            tx.commit();
            fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarDev(DevolucaoBEAN c) {
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
