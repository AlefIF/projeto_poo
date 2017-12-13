/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.bdii.TechSales.JpaUtil.JpaUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Alef
 */
public class FuncionarioHiber {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public ArrayList<FuncionarioBEAN> listarFun() {
        Query q = manager.createQuery("from FuncionarioBEAN");
        ArrayList<FuncionarioBEAN> funList = (ArrayList<FuncionarioBEAN>) q.getResultList();
        tx.commit();
        return funList;
    }

    public void cadFun(FuncionarioBEAN c) {
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteFun(FuncionarioBEAN c) {

        try {
            FuncionarioBEAN a = manager.find(FuncionarioBEAN.class, c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarFun(FuncionarioBEAN c) {
        try {
            manager.flush();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

}
