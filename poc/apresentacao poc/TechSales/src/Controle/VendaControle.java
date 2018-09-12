/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.VendaBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author Alef
 */
public class VendaControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public int cadastrar(VendaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        return c.getVenCodigo();
    }

    public ArrayList<VendaBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from VendaBEAN");
        ArrayList<VendaBEAN> venList = (ArrayList<VendaBEAN>) q.getResultList();
        tx.commit();
        return venList;
    }

    public boolean editar(VendaBEAN c) {
        try {
            começar();
            manager.flush();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remover(int c) {
        try {
            começar();
            VendaBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public VendaBEAN localizar(int c) {
        VendaBEAN a = manager.find(VendaBEAN.class, c);
        return a;
    }

}
