/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.LocacaoBEAN;
import Modelo.LocacaoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maycon Jonathan
 */
public class LocacaoControle {

    private LocacaoDAO lDAO = new LocacaoDAO();
    //private int codigo = tfCod.frmcp;

    //public int atualizaCodigo(){
    //codigo++;   
    //return codigo;
    //}
    public void cadastrar(LocacaoBEAN l) {
        lDAO.cadastrar(l);
    }

    public ArrayList<LocacaoBEAN> listarALL() {
        try {
            return lDAO.listarALL();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public LocacaoBEAN localizar(String codigo) {
        return lDAO.localizar(codigo);
    }

    public boolean editar(LocacaoBEAN l) {
        return lDAO.editar(l);
    }

    public boolean remover(String codigo) {
        return lDAO.remover(codigo);
    }

    public ArrayList<LocacaoBEAN> localizarCli(int cod) {
        return lDAO.localizarCLi(cod);
    }

}
