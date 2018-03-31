/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.LocacaoBEAN;
import Modelo.LocacaoDAO;
import Modelo.LocacaoHiber;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Maycon Jonathan
 */
public class LocacaoControle {

    private LocacaoHiber locHN = new LocacaoHiber();
    private LocacaoDAO lDAO = new LocacaoDAO();

    public void cadastrar(LocacaoBEAN l) {
        //lDAO.cadastrar(l);
        locHN.cadLoc(l);
    }

    public ArrayList<LocacaoBEAN> listarALL() {
        /*try {
             return lDAO.listarALL();
            //return locHN.listarLoc();
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;*/
        return locHN.listarLoc();
    }

    public LocacaoBEAN localizar(String codigo) {
        return lDAO.localizar(codigo);
    }

    public boolean editar(LocacaoBEAN l) {
        //return lDAO.editar(l);
        return locHN.editarLoc(l);
    }

    public boolean remover(int codigo) {
        //return lDAO.remover(codigo);
        return locHN.deleteLoc(codigo);
    }

    public ArrayList<LocacaoBEAN> localizarCli(int cod) {
        return lDAO.localizarCLi(cod);
    }

    public void iniciar() {
        locHN.começar();
    }

    public void fechar() {
        locHN.fechar();
    }

}
