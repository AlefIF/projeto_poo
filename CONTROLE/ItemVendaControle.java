/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author Alef
 */
public class ItemVendaControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar2(Item_VendaBEAN w) {
        começar();
        manager.persist(w);
        tx.commit();
    }

    public Item_VendaBEAN localizarCodigo(int c) {
        Item_VendaBEAN a = manager.find(Item_VendaBEAN.class, c);
        return a;
    }

    public boolean editar2(Item_VendaBEAN w) {
        try {
            começar();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remover2(int c) {
        try {
            começar();
            Item_VendaBEAN a = localizarCodigo(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Item_VendaBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from Item_VendaBEAN");
        ArrayList<Item_VendaBEAN> itvList = (ArrayList<Item_VendaBEAN>) q.getResultList();
        tx.commit();
        return itvList;
    }
}
