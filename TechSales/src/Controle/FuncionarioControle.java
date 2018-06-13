/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

//import Modelo.ConnectionFactory;
import Modelo.FuncionarioBEAN;
import Modelo.FuncionarioDAO;
import Modelo.FuncionarioHiber;
import java.util.ArrayList;

/**
 *
 * @author LUCASP
 */
public class FuncionarioControle {

    /* FuncionarioHiber funH = new FuncionarioHiber();

    public void cadastrar(FuncionarioBEAN c) {
        funH.cadFun(c);
    }

    public boolean verificaLogin(String senha) {
        return funH.verificaLogin(senha);
    }

    public void editar(FuncionarioBEAN c) {
        funH.editarFun(c);
    }

    public FuncionarioBEAN localizarCodigo(int cod) {
        return funH.listarPorCod(cod);
    }

    public ArrayList<FuncionarioBEAN> ListarALL() {
        ArrayList<FuncionarioBEAN> auxAL = (ArrayList<FuncionarioBEAN>) funH.listarFun();
        return auxAL;
    }

    public void excluir(int codigo) {
        funH.deleteFun(codigo);
    }

    public boolean verificaLogin2(String login, String senha) {
        return funH.verificaLogin2(login, senha);
    }

    public void iniciar() {
        funH.começar();
    }

    public void fechar() {
        funH.fechar();
    }*/
    private FuncionarioDAO fDAO = new FuncionarioDAO();

    public void cadastrar(FuncionarioBEAN c) {
        fDAO.cadastrar(c);
    }

    public ArrayList<FuncionarioBEAN> listarALL() {
        return fDAO.listarALL();
    }

    public boolean editar(FuncionarioBEAN c) {
        return fDAO.editar(c);
    }

    public boolean remover(int codigo) {
        return fDAO.remover(codigo);
    }

    public FuncionarioBEAN localizarCodigo(int a) {
        return fDAO.localizarCodigo(a);
    }
}
