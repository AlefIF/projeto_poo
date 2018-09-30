/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.JogoLocacaoBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author Alef
 */
public class JogoLocacaoControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(JogoLocacaoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<JogoLocacaoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from JogoLocacaoBEAN");
        ArrayList<JogoLocacaoBEAN> jogList = (ArrayList<JogoLocacaoBEAN>) q.getResultList();
        tx.commit();
        return jogList;
    }

    public boolean editar(JogoLocacaoBEAN c) {
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
            JogoLocacaoBEAN a = localizarCodigo(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public JogoLocacaoBEAN localizarCodigo(int c) {
        JogoLocacaoBEAN a = manager.find(JogoLocacaoBEAN.class, c);
        return a;
    }

}
