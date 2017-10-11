/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

//import Modelo.ConnectionFactory;
import Modelo.UserBEAN;
import Modelo.UserDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LUCASP
 */
public class ControleUser {

    UserBEAN user = new UserBEAN();
    UserDAO dao = new UserDAO();

    public void cadastrar(String nome, int idade, String endereco, String cpf, String np, String nomeusuario, String senha, String telefone) {
        user.setNome(nome);
        user.setIdade(idade);
        user.setEndereco(endereco);
        user.setCpf(cpf);
        user.setNisPis(np);
        user.setNomeUsuario(nomeusuario);
        user.setSenha(senha);
        user.setTelefone(telefone);
        dao.cadastrar(user);
    }

    public boolean verificaLogin(String senha) {
        return dao.verificaLogin(senha);
    }

    public void editar(String nome, int idade, String endereco, String cpf, String np, String nomeusuario, String senha, String telefone) {
        user.setNome(nome);
        user.setIdade(idade);
        user.setEndereco(endereco);
        user.setCpf(cpf);
        user.setNisPis(np);
        user.setNomeUsuario(nomeusuario);
        user.setSenha(senha);
        user.setTelefone(telefone);
        dao.editar(user);
    }

    public ArrayList<UserBEAN> ListarALL() {
        ArrayList<UserBEAN> auxAL = (ArrayList<UserBEAN>) dao.ListarALL();
        return auxAL;
    }

    public void excluir(int codigo) {
        user.setCodigo(codigo);
        dao.excluir(user);
    }

    public boolean verificaLogin2(String login, String senha) {
        return dao.verificaLogin2(login, senha);
    }
}
