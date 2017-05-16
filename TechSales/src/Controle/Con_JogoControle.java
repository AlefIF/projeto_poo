/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Con_jogoBEAN;
import Modelo.Con_jogoMySqlDAO;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Con_JogoControle {

    private Con_jogoMySqlDAO cjDAO = new Con_jogoMySqlDAO();
    private int codigo = 0;

    public int atualizaCodigo2() {
        codigo++;
        return codigo;
    }

    public void cadastrar2(Con_jogoBEAN w) {

        w.setCjg_joCodigo(this.atualizaCodigo2());
        cjDAO.cadastrar2(w);
    }

    public boolean editar2(Con_jogoBEAN w) {
        return cjDAO.editar2(w);
    }

    public boolean remover2(int codigo) {
        return cjDAO.remover2(codigo);
    }

    public ArrayList<Con_jogoBEAN> listarALL() {
        return cjDAO.listarALL();
    }
}
