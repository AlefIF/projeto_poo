/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import Modelo.ClienteBEAN;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

public class ClienteControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(ClienteBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<ClienteBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from ClienteBEAN");
        ArrayList<ClienteBEAN> cliList = (ArrayList<ClienteBEAN>) q.getResultList();
        tx.commit();
        return cliList;
    }

    public boolean editar(ClienteBEAN c) {
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
            ClienteBEAN a = localizarCodigo(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ClienteBEAN localizarCodigo(int c) {
        ClienteBEAN a = manager.find(ClienteBEAN.class, c);
        return a;
    }

    public ArrayList<ClienteBEAN> localizarNome(String a) {
        começar();
        Query q = manager.createQuery("from ClienteBEAN where cliNome like "+a+";");
        ArrayList<ClienteBEAN> cliList = (ArrayList<ClienteBEAN>) q.getResultList();
        tx.commit();
        return cliList;
    }

}
