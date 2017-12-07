/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.DevolucaoBEAN;
import Modelo.DevolucaoDAO;
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
    //private int codigo = tfCod.frmcp;

    //public int atualizaCodigo(){
    //codigo++;   
    //return codigo;
    //}
    public void cadastrar(DevolucaoBEAN d) {
        dDAO.cadastrar(d);
    }

}
