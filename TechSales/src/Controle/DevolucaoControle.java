/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.DevolucaoBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author Maycon Jonathan
 */
public class DevolucaoControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(DevolucaoBEAN d) {
        começar();
        manager.persist(d);
        tx.commit();
    }

    public ArrayList<DevolucaoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from DevolucaoBEAN");
        ArrayList<DevolucaoBEAN> devList = (ArrayList<DevolucaoBEAN>) q.getResultList();
        tx.commit();
        return devList;
    }

    public boolean editar(DevolucaoBEAN l) {
        try {
            começar();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public DevolucaoBEAN localizar(int c) {
        DevolucaoBEAN a = manager.find(DevolucaoBEAN.class, c);
        return a;
    }

    public boolean remover(int c) {
        try {
            começar();
            DevolucaoBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
