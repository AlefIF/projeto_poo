/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteBEAN {

    private int cliCodigo;
    private String cliNome;
    private int cliIdade;
    private String cliCpf;
    private String cliTelefone;
    private String cliEmail;
    private EnderecoBEAN endereco;

    @Id
    @GeneratedValue
    public int getCliCodigo() {
        return cliCodigo;
    }

    public void setCliCodigo(int cliCodigo) {
        this.cliCodigo = cliCodigo;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public int getCliIdade() {
        return cliIdade;
    }

    public void setCliIdade(int cliIdade) {
        this.cliIdade = cliIdade;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public String getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(String cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public String getCliEmail() {
        return cliEmail;
    }

    public void setCliEmail(String cliEmail) {
        this.cliEmail = cliEmail;
    }

    @Embedded
    public EnderecoBEAN getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBEAN endereco) {
        this.endereco = endereco;
    }

}
