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
import javax.persistence.Table;

/**
 *
 * @author LUCASP
 */
@Entity
@Table(name="funcionario")
public class FuncionarioBEAN {

    private int codigo;
    private String nome;
    private int idade;
    private String endereco;
    private String cpf;
    private String nomeUsuario;
    private String senha;
    private String telefone;
    private String nisPis;
    private List<LocacaoBEAN> loc;
    private List<DevolucaoBEAN> dev;
    private List<VendaBEAN> venda;

    @Id
    @GeneratedValue
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNisPis() {
        return nisPis;
    }

    public void setNisPis(String nisPis) {
        this.nisPis = nisPis;
    }

    @OneToMany(mappedBy = "loc_funCodigo")
    @Column(nullable = true)
    public List<LocacaoBEAN> getLoc() {
        return loc;
    }

    public void setLoc(List<LocacaoBEAN> loc) {
        this.loc = loc;
    }

    @OneToMany(mappedBy = "dev_funCodigo")
    @Column(nullable = true)
    public List<DevolucaoBEAN> getDev() {
        return dev;
    }

    public void setDev(List<DevolucaoBEAN> dev) {
        this.dev = dev;
    }

    @OneToMany(mappedBy = "ven_funCodigo")
    @Column(nullable = true)
    public List<VendaBEAN> getVenda() {
        return venda;
    }

    public void setVenda(List<VendaBEAN> venda) {
        this.venda = venda;
    }

}
