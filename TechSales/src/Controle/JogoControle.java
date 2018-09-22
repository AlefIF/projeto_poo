/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import Modelo.JogoBEAN;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author admin
 */
public class JogoControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(JogoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<JogoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from JogoBEAN");
        ArrayList<JogoBEAN> jogList = (ArrayList<JogoBEAN>) q.getResultList();
        tx.commit();
        return jogList;
    }

    public boolean editar(JogoBEAN c) {
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
            JogoBEAN a = localizarCodigo(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<JogoBEAN> localizarNome(String a) {
        começar();
        Query q = manager.createQuery("from JogoBEAN where joNome like " + a);
        ArrayList<JogoBEAN> jogListN = (ArrayList<JogoBEAN>) q.getResultList();
        tx.commit();
        return jogListN;
    }

    public JogoBEAN localizarCodigo(int c) {
        JogoBEAN a = manager.find(JogoBEAN.class, c);
        return a;
    }

}
