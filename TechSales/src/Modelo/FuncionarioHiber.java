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
        começar();
        Query q = manager.createQuery("from funcionario");
        ArrayList<FuncionarioBEAN> funList = (ArrayList<FuncionarioBEAN>) q.getResultList();
        tx.commit();
        fechar();
        return funList;
    }

    public void cadFun(FuncionarioBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
        fechar();
    }

    public boolean deleteFun(FuncionarioBEAN c) {

        try {
            começar();
            FuncionarioBEAN a = manager.find(FuncionarioBEAN.class, c);
            manager.remove(a);
            tx.commit();
            fechar();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarFun(FuncionarioBEAN c) {
        try {
            começar();
            manager.flush();
            tx.commit();
            fechar();
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
