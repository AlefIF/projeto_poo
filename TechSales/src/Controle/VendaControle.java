/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.VendaBEAN;
import Modelo.VendaDAO;
import Modelo.VendaHiber;
import java.util.ArrayList;

/**
 *
 * @author Alef
 */
public class VendaControle {

    private VendaHiber venHN = new VendaHiber();
    private VendaDAO venDAO = new VendaDAO();

    public int cadastrar(VendaBEAN c) {

        int cod = venDAO.cadastrar(c);
        //int cod = venHN.cadVen(c);
        return cod;
    }

    public ArrayList<VendaBEAN> listarALL() {
        return venDAO.listarALL();
        //return venHN.listarVen();
    }

    public boolean editar(VendaBEAN c) {
        return venDAO.editar(c);
        //return venHN.editarVen(c);
    }

    public boolean remover(int codigo) {
        return venDAO.remover(codigo);
        //return venHN.deleteVen(codigo);
    }

    public ArrayList consultar(String consulta) {
        return venDAO.consultar(consulta);
    }

    public void iniciar() {
        venHN.começar();
    }

    public void fechar() {
        venHN.fechar();
    }

}
