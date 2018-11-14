/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.EmpregoBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author Alef
 */
public class EmpregoControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(EmpregoBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public ArrayList<EmpregoBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from EmpregoBEAN");
        ArrayList<EmpregoBEAN> empList = (ArrayList<EmpregoBEAN>) q.getResultList();
        tx.commit();
        return empList;
    }

    public boolean editar(EmpregoBEAN c) {
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
            EmpregoBEAN a = localizarCodigo(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public EmpregoBEAN localizarCodigo(int c) {
        EmpregoBEAN a = manager.find(EmpregoBEAN.class, c);
        return a;
    }

}
