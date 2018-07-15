/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;
import Modelo.ListaDesejoBEAN;
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
public class ListaDesejoControle {
    
    EntityManager manager = JpaUtil.getEntityManager();
    EntityTransaction tx = manager.getTransaction();

    public void começar() {
        tx.begin();
    }

    public void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(ListaDesejoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<ListaDesejoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from ListaDesejoBEAN");
        ArrayList<ListaDesejoBEAN> catList = (ArrayList<ListaDesejoBEAN>) q.getResultList();
        tx.commit();
        //fechar();
        return catList;
    }

    public ListaDesejoBEAN localizar(int a) {
        ListaDesejoBEAN c = manager.find(ListaDesejoBEAN.class, a);
        return c;
    }

    public boolean editar(ListaDesejoBEAN a) {
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
            ListaDesejoBEAN a = localizar(c);
            manager.remove(a);
            tx.commit();
            //fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
