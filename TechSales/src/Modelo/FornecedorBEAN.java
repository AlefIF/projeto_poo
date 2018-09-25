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

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "fornecedor")
public class FornecedorBEAN {

    private int forCodigo;
    private String forNomeEmpresa;
    private String forEmail;
    private String forTelefoneContato;
    private String forCNPJ_CPF;
    private String forPais;
    private String forAnotacoes;
    private EnderecoBEAN endereco;

    @Id
    @GeneratedValue
    public int getForCodigo() {
        return forCodigo;
    }

    public void setForCodigo(int forCodigo) {
        this.forCodigo = forCodigo;
    }

    public String getForNomeEmpresa() {
        return forNomeEmpresa;
    }

    public void setForNomeEmpresa(String forNomeEmpresa) {
        this.forNomeEmpresa = forNomeEmpresa;
    }

    public String getForEmail() {
        return forEmail;
    }

    public void setForEmail(String forEmail) {
        this.forEmail = forEmail;
    }

    public String getForTelefoneContato() {
        return forTelefoneContato;
    }

    public void setForTelefoneContato(String forTelefoneContato) {
        this.forTelefoneContato = forTelefoneContato;
    }

    public String getForCNPJ() {
        return forCNPJ_CPF;
    }

    public void setForCNPJ(String forCNPJ) {
        this.forCNPJ_CPF = forCNPJ;
    }

    public String getForPais() {
        return forPais;
    }

    public void setForPais(String forPais) {
        this.forPais = forPais;
    }

    public String getForAnotacoes() {
        return forAnotacoes;
    }

    public void setForAnotacoes(String forAnotacoes) {
        this.forAnotacoes = forAnotacoes;
    }

    @Embedded
    public EnderecoBEAN getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoBEAN endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public String toString() {
        return getForNomeEmpresa(); 
    }
}
