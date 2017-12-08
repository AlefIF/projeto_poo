/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import Modelo.ClienteBEAN;
import Modelo.ClienteHiber;
import Modelo.ClienteMySqlDAO;

public class ClienteControle {

    private ClienteHiber cliHN = new ClienteHiber();
    private ClienteMySqlDAO cDAO = new ClienteMySqlDAO();
    private int codigo = 0;

    public int atualizaCodigo() {
        codigo++;
        return codigo;
    }

    public void cadastrar(ClienteBEAN c) {
        c.setCod(this.atualizaCodigo());
        // cDAO.cadastrar(c);
        cliHN.cadCli(c);
    }

    public ArrayList<ClienteBEAN> listarALL() {
        //return cDAO.listarALL();
        return cliHN.listarCli();
    }

    public ClienteBEAN localizarCPF(String cpf) {
        return cDAO.localizarCPF(cpf);
    }

    public boolean editar(ClienteBEAN c) {
        //return cDAO.editar(c);
        return cliHN.editarCli(c);
    }

    public boolean remover(int codigo) {
        //return cDAO.remover(codigo);
        return cliHN.deleteCli(codigo);
    }

    public ClienteBEAN localizarCodigo(int busca) {
        return cDAO.localizarCodigo(busca);
    }

    public ArrayList<ClienteBEAN> localizarNome(String busca) {
        return cDAO.localizarNome(busca);
    }

}
