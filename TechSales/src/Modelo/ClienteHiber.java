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
public class ClienteHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<ClienteBEAN> listarCli() {
        Query q = manager.createQuery("from ClienteBEAN");
        ArrayList<ClienteBEAN> cliList = (ArrayList<ClienteBEAN>) q.getResultList();
        tx.commit();
        return cliList;
    }

    public void cadCli(ClienteBEAN c) {
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteCli(int c) {
        try {
            ClienteBEAN a = manager.find(ClienteBEAN.class, c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarCli(ClienteBEAN c) {
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
