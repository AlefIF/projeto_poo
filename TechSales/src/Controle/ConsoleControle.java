/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ConsoleBEAN;
import Modelo.ConsoleMySqlDAO;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ConsoleControle {

    private ConsoleMySqlDAO conDAO = new ConsoleMySqlDAO();
    private int codigo = 0;

    public int atualizaCodigo() {
        codigo++;
        return codigo;
    }

    public void cadastrar(ConsoleBEAN c) {
        c.setConCodigo(this.atualizaCodigo());
        conDAO.cadastrar(c);
    }

    public ArrayList<ConsoleBEAN> listarALL() {
        return conDAO.listarALL();
    }

    public boolean editar(ConsoleBEAN c) {
        return conDAO.editar(c);
    }

    public boolean remover(int codigo) {
        return conDAO.remover(codigo);
    }
}
