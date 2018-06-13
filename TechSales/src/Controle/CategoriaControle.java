/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.CategoriaBEAN;
import Modelo.CategoriaHiber;
import Modelo.CategoriaMysqlDAO;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CategoriaControle {

    private CategoriaHiber catHN = new CategoriaHiber();
    private CategoriaMysqlDAO catDAO = new CategoriaMysqlDAO();

    public void cadastrar(CategoriaBEAN c) {
        catDAO.cadastrar(c);
        //catHN.cadCat(c);
    }

    public ArrayList<CategoriaBEAN> listarALL() {
        return catDAO.listarALL();
        //return catHN.listarCat();
    }

    public CategoriaBEAN localizar(int a) {
        return catHN.listarPorCod(a);
    }

    public boolean editar(CategoriaBEAN a) {
        return catDAO.editar(a);
        //return catHN.editarCat(a);
    }

    public boolean remover(int codigo) {
        return catDAO.remover(codigo);
        //return catHN.deleteCat(codigo);
    }

    public void iniciar() {
        catHN.começar();
    }

    public void fechar() {
        catHN.fechar();
    }

}
