/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.FuncionarioBEAN;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import jpa.JpaUtil;

/**
 *
 * @author LUCASP
 */
public class FuncionarioControle {

    private static EntityManager manager = JpaUtil.getEntityManager();
    private static EntityTransaction tx = manager.getTransaction();

    public static void começar() {
        tx.begin();
    }

    public static void fechar() {
        manager.close();
        JpaUtil.close();
    }

    public void cadastrar(FuncionarioBEAN c) {
        começar();
        manager.persist(c);
        tx.commit();
    }

    public boolean verificaLogin(String senha) {
        boolean verifica = false;
        ArrayList<FuncionarioBEAN> al = listarALL();
        for (FuncionarioBEAN f : al) {
            if ((f.getNome().equals("ADM")) && (f.getSenha().equals(senha))) {
                verifica = true;
            }
        }
        return verifica;
    }

    public boolean editar(FuncionarioBEAN c) {
        try {
            começar();
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public FuncionarioBEAN localizarCodigo(int c) {
        FuncionarioBEAN a = manager.find(FuncionarioBEAN.class, c);
        return a;

    }

    public ArrayList<FuncionarioBEAN> listarALL() {
        começar();
        Query q = manager.createQuery("from FuncionarioBEAN");
        ArrayList<FuncionarioBEAN> funList = (ArrayList<FuncionarioBEAN>) q.getResultList();
        tx.commit();
        return funList;
    }

    public boolean excluir(int c) {
        try {
            começar();
            FuncionarioBEAN a = localizarCodigo(c);
            manager.remove(a);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verificaLogin2(String login, String senha) {
        boolean verifica = false;
        ArrayList<FuncionarioBEAN> al = listarALL();
        for (FuncionarioBEAN f : al) {
            if ((f.getNome().equals(login)) && (f.getSenha().equals(senha))) {
                verifica = true;
            }
        }
        return verifica;
    }

    public ArrayList<FuncionarioBEAN> readForNome(String a) {
        começar();
        Query q = manager.createQuery("from FuncionarioBEAN WHERE funNome LIKE" + a);
        ArrayList<FuncionarioBEAN> funList = (ArrayList<FuncionarioBEAN>) q.getResultList();
        tx.commit();
        return funList;
    }

}
