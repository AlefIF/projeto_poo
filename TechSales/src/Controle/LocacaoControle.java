/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.LocacaoBEAN;
import java.util.ArrayList;
;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author Maycon Jonathan
 */


public class LocacaoControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(LocacaoBEAN l) {
        começar();
        manager.persist(l);
        tx.commit();
    }

    public ArrayList<LocacaoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from LocacaoBEAN");
        ArrayList<LocacaoBEAN> locList = (ArrayList<LocacaoBEAN>) q.getResultList();
        tx.commit();
        return locList;
    }

    public LocacaoBEAN localizarLoc(int c) {
        LocacaoBEAN a = manager.find(LocacaoBEAN.class, c);
        return a;
    }

    public boolean editar(LocacaoBEAN l) {
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
            LocacaoBEAN a = localizarLoc(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<LocacaoBEAN> localizarCli(int c) {
        começar();
        Query q = manager.createQuery("from LocacaoBEAN where loc_cliCodigo ="+c);
        ArrayList<LocacaoBEAN> locList = (ArrayList<LocacaoBEAN>) q.getResultList();
        tx.commit();
        return locList;
    }

}
