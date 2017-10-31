/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Item_VendaBEAN;
import Modelo.Item_VendaDAO;
import java.util.ArrayList;

/**
 *
 * @author Alef
 */
public class ItemVendaControle {
     private Item_VendaDAO itvDAO = new Item_VendaDAO();
    private int codigo = 0;

    public int atualizaCodigo2() {
        codigo++;
        return codigo;
    }

    public void cadastrar2(Item_VendaBEAN w) {
        w.setIv_venCodigo(this.atualizaCodigo2());
        itvDAO.cadastrar(w);
    }

    public boolean editar2(Item_VendaBEAN w) {
        return itvDAO.editar(w);
    }

    public boolean remover2(int codigo) {
        return itvDAO.remover(codigo);
    }

    public ArrayList<Item_VendaBEAN> listarALL() {
        return itvDAO.listarALL();
    }
}
