/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ConsoleBEAN;
import Modelo.ConsoleHiber;
import Modelo.ConsoleMySqlDAO;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class ConsoleControle {

    private ConsoleHiber conHN = new ConsoleHiber();
    private ConsoleMySqlDAO conDAO = new ConsoleMySqlDAO();

    public void cadastrar(ConsoleBEAN c) {
        conDAO.cadastrar(c);
        //conHN.cadCon(c);
    }

    public ArrayList<ConsoleBEAN> listarALL() {
        return conDAO.listarALL();
        //return conHN.listarCon();

    }

    public ConsoleBEAN localizar(int a) {
        return conHN.listarPorCod(a);
    }

    public boolean editar(ConsoleBEAN c) {
        return conDAO.editar(c);
        //return conHN.editarCon(c);
    }

    public boolean remover(int codigo) {
        return conDAO.remover(codigo);
        //return conHN.deleteCon(codigo);
    }

    public void iniciar() {
        conHN.começar();
    }

    public void fechar() {
        conHN.fechar();
    }
}
