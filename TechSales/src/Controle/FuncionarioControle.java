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
    

    FuncionarioDAO dao = new FuncionarioDAO();
    FuncionarioHiber funH = new FuncionarioHiber();
    
    public void cadastrar(FuncionarioBEAN c) {      
        dao.cadastrar(c);
    }

    public boolean verificaLogin(String senha) {
        return dao.verificaLogin(senha);
    }

    public void editar(FuncionarioBEAN c) {  
        dao.editar(c);
    }

    public ArrayList<FuncionarioBEAN> ListarALL() {
        ArrayList<FuncionarioBEAN> auxAL = (ArrayList<FuncionarioBEAN>) dao.ListarALL();
        return auxAL;
    }

    public void excluir(int codigo) {
        dao.remover(codigo);
    }

    public boolean verificaLogin2(String login, String senha) {
        return dao.verificaLogin2(login, senha);
    }
    
       
    public void iniciar(){
        funH.começar();
    }
    public void fechar(){
        funH.fechar();
    }


}
