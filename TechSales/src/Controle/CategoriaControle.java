/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.CategoriaBEAN;
import Modelo.CategoriaMysqlDAO;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CategoriaControle {

    private CategoriaMysqlDAO catDAO = new CategoriaMysqlDAO();
    private int codigo = 0;

    public int atualizaCodigo() {
        codigo++;
        return codigo;
    }

    public void cadastrar(CategoriaBEAN c) {
        c.setCatCodigo(this.atualizaCodigo());
        catDAO.cadastrar(c);
    }

    public ArrayList<CategoriaBEAN> listarALL() {
        return catDAO.listarALL();
    }

    public boolean editar(CategoriaBEAN c) {
        return catDAO.editar(c);
    }

    public boolean remover(int codigo) {
        return catDAO.remover(codigo);
    }

}
