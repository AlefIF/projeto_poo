/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.VendaAPrazoBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author Alef
 */
public class VendaAPrazoControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(VendaAPrazoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<VendaAPrazoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from VendaAPrazoBEAN");
        ArrayList<VendaAPrazoBEAN> jogList = (ArrayList<VendaAPrazoBEAN>) q.getResultList();
        tx.commit();
        return jogList;
    }

    public boolean editar(VendaAPrazoBEAN c) {
        try {
            começar();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remover(int c) {
        try {
            começar();
            VendaAPrazoBEAN a = localizarCodigo(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public VendaAPrazoBEAN localizarCodigo(int c) {
        VendaAPrazoBEAN a = manager.find(VendaAPrazoBEAN.class, c);
        return a;
    }
}
