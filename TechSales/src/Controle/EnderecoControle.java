/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.EnderecoBEAN;
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
public class EnderecoControle {

    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(EnderecoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<EnderecoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from EnderecoBEAN");
        ArrayList<EnderecoBEAN> endList = (ArrayList<EnderecoBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return endList;
    }

    public EnderecoBEAN localizar(int a) {
        EnderecoBEAN c = manager.find(EnderecoBEAN.class, a);
        return c;
    }

    public boolean editar(EnderecoBEAN a) {
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
            EnderecoBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
