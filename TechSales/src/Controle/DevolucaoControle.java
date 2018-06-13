/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.DevolucaoBEAN;
import Modelo.DevolucaoDAO;
import Modelo.DevolucaoHiber;
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
public class DevolucaoControle {

    private DevolucaoDAO dDAO = new DevolucaoDAO();
    private LocacaoDAO lDao = new LocacaoDAO();
    //private DevolucaoHiber dvH = new DevolucaoHiber();

    public void cadastrar(DevolucaoBEAN d) {
        dDAO.cadastrar(d);
        //dvH.cadDev(d);
    }

    public ArrayList<DevolucaoBEAN> listarALL() {
        return dDAO.listarALL();
        //return dvH.listarDev();
    }

    public boolean editar(DevolucaoBEAN l) {
        return dDAO.editar(l);
        //return dvH.editarDev(l);
    }

    public boolean remover(int codigo) {
        return dDAO.remover(codigo);
        //return dvH.deleteDev(codigo);
    }

    /*public void iniciar() {
        dvH.começar();
    }

    public void fechar() {
        dvH.fechar();
    }*/
}
