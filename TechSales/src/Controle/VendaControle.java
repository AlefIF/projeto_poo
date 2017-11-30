/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.VendaBEAN;
import Modelo.VendaDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alef
 */
public class VendaControle {

    private VendaDAO venDAO = new VendaDAO();
    private int codigo = 0;

    public int atualizaCodigo() {
        codigo++;
        return codigo;
    }

    public int cadastrar(VendaBEAN c) {
        c.setVenCodigo(this.atualizaCodigo());
        int cod = venDAO.cadastrar(c);
        return cod;
    }

    public ArrayList<VendaBEAN> listarALL() {
        return venDAO.listarALL();
    }

    public boolean editar(VendaBEAN c) {
        return venDAO.editar(c);
    }

    public boolean remover(int codigo) {
        return venDAO.remover(codigo);
    }

    public ArrayList consultar(String consulta) {
        return venDAO.consultar(consulta);
    }

}
