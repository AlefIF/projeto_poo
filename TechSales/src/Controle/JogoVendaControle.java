/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.JogoVendaBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author Alef
 */
public class JogoVendaControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(JogoVendaBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<JogoVendaBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from JogoVendaBEAN");
        ArrayList<JogoVendaBEAN> jogList = (ArrayList<JogoVendaBEAN>) q.getResultList();
        tx.commit();
        return jogList;
    }

    public boolean editar(JogoVendaBEAN c) {
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
            JogoVendaBEAN a = localizarCodigo(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public JogoVendaBEAN localizarCodigo(int c) {
        JogoVendaBEAN a = manager.find(JogoVendaBEAN.class, c);
        return a;
    }

}
