/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import Modelo.JogoBEAN;
import Modelo.JogoHiber;
import Modelo.JogoMySqlDAO;

/**
 *
 * @author admin
 */
public class JogoControle {

    private JogoHiber jogHN = new JogoHiber();
    private JogoMySqlDAO jDAO = new JogoMySqlDAO();

    private int codigo = 0;

    public int atualizaCodigo() {
        codigo++;
        return codigo;
    }

    public void cadastrar(JogoBEAN c) {
        c.setJoCodigo(this.atualizaCodigo());
        //jDAO.cadastrar(c);
        jogHN.cadJog(c);
    }

    public ArrayList<JogoBEAN> listarALL() {
        //return jDAO.listarALL();
        return jogHN.listarJog();
    }

    public boolean editar(JogoBEAN c) {
        //return jDAO.editar(c);
        return jogHN.editarJog(c);
    }

    public boolean editarINVAL(JogoBEAN c) {
        return jDAO.editarINVAL(c);
    }

    public boolean remover(int codigo) {
        //return jDAO.remover(codigo);
        return jogHN.deleteJog(codigo);
    }

    public void editarDisponibilidade(JogoBEAN l) {
        jDAO.editarDisponibilidade(l);
    }

    public ArrayList<JogoBEAN> localizarNome(String nome) {
        return jDAO.localizarNome(nome);
    }

    public Object localizarCodigo(int loc_jogCodigo) {
        return jDAO.localizarCodigo(loc_jogCodigo);
    }

}
