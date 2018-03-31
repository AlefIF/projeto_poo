/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import jpa.JpaUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Alef
 */
public class ClienteHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<ClienteBEAN> listarCli() {
        começar();
        Query q = manager.createQuery("from ClienteBEAN");
        ArrayList<ClienteBEAN> cliList = (ArrayList<ClienteBEAN>) q.getResultList();
        tx.commit();
        return cliList;
    }

    public void cadCli(ClienteBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteCli(int c) {
        try {
            começar();
            ClienteBEAN a = listarPorCod(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarCli(ClienteBEAN c) {
        try {
            começar();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ClienteBEAN listarPorCod(int c) {
        ClienteBEAN a = manager.find(ClienteBEAN.class, c);
        return a;
    }

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

}
