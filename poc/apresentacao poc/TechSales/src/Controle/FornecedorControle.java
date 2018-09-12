/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.FornecedorBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;
import org.hibernate.HibernateException;

/**
 *
 * @author Alef
 */
public class FornecedorControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(FornecedorBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<FornecedorBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from FornecedorBEAN");
        ArrayList<FornecedorBEAN> forList = (ArrayList<FornecedorBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return forList;
    }

    public FornecedorBEAN localizar(int a) {
        FornecedorBEAN c = manager.find(FornecedorBEAN.class, a);
        return c;
    }

    public boolean editar(FornecedorBEAN a) {
        try {
            começar();
            tx.commit();
            // fechar();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    public boolean remover(int c) {
        try {
            começar();
            FornecedorBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
