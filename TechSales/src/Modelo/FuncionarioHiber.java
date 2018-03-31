/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import jpa.JpaUtil;
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
        Query q = manager.createQuery("from FuncionarioBEAN");
        ArrayList<FuncionarioBEAN> funList = (ArrayList<FuncionarioBEAN>) q.getResultList();
        tx.commit();
        return funList;
    }

    public void cadFun(FuncionarioBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public boolean deleteFun(int c) {

        try {
            começar();
            FuncionarioBEAN a = listarPorCod(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editarFun(FuncionarioBEAN c) {
        try {
            começar();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public FuncionarioBEAN listarPorCod(int c) {
        FuncionarioBEAN a = manager.find(FuncionarioBEAN.class, c);
        return a;
    }

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public boolean verificaLogin(String senha) {
        boolean verifica = false;
        ArrayList<FuncionarioBEAN> al = listarFun();
        for (FuncionarioBEAN f : al) {
            if ((f.getNome().equals("ADM")) && (f.getSenha().equals(senha))) {
                verifica = true;
            }
        }
        return verifica;
    }

    public boolean verificaLogin2(String login, String senha) {
        boolean verifica = false;
        ArrayList<FuncionarioBEAN> al = listarFun();
        for (FuncionarioBEAN f : al) {
            if ((f.getNome().equals(login)) && (f.getSenha().equals(senha))) {
                verifica = true;
            }
        }
        return verifica;
    }
}
