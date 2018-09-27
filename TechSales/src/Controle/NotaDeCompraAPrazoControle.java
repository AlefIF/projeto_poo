/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.LucroBEAN;
import Modelo.NotaDeCompraPrazoBEAN;
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
public class NotaDeCompraAPrazoControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(NotaDeCompraPrazoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<NotaDeCompraPrazoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from NotaDeCompraPrazoBEAN");
        ArrayList<NotaDeCompraPrazoBEAN> lucList = (ArrayList<NotaDeCompraPrazoBEAN>) q.getResultList();
        tx.commit();
        return lucList;
    }

    public NotaDeCompraPrazoBEAN localizar(int a) {
        NotaDeCompraPrazoBEAN c = manager.find(NotaDeCompraPrazoBEAN.class, a);
        return c;
    }

    public boolean editar(NotaDeCompraPrazoBEAN a) {
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
            NotaDeCompraPrazoBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
