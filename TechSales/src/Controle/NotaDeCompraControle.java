/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.NotaDecompraBEAN;
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
public class NotaDeCompraControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(NotaDecompraBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<NotaDecompraBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from NotaDecompraBEAN");
        ArrayList<NotaDecompraBEAN> notdList = (ArrayList<NotaDecompraBEAN>) q.getResultList();
        tx.commit();
        return notdList;
    }

    public NotaDecompraBEAN localizar(int a) {
        NotaDecompraBEAN c = manager.find(NotaDecompraBEAN.class, a);
        return c;
    }

    public boolean editar(NotaDecompraBEAN a) {
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
            NotaDecompraBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
