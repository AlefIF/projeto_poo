/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClienteBEAN {

    private int cod;
    private String nome;
    private int idade;
    private String cpf;
    private String endereco;
    private String telefone;
    private List<VendaBEAN> venda;
    private List<LocacaoBEAN> locacao;
    private List<DevolucaoBEAN> devolucao;

    @Id
    @GeneratedValue
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @OneToMany(mappedBy = "ven_cliCodigo")
    @Column(nullable = true)
    public List<VendaBEAN> getVenda() {
        return venda;
    }

    public void setVenda(List<VendaBEAN> venda) {
        this.venda = venda;
    }

    @OneToMany(mappedBy = "loc_cliCodigo")
    @Column(nullable = true)
    public List<LocacaoBEAN> getLocacao() {
        return locacao;
    }

    public void setLocacao(List<LocacaoBEAN> aluguel) {
        this.locacao = aluguel;
    }

    @OneToMany(mappedBy = "dev_cliCodigo")
    @Column(nullable = true)
    public List<DevolucaoBEAN> getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(List<DevolucaoBEAN> devolucao) {
        this.devolucao = devolucao;
    }

}
