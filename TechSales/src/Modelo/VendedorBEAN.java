/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "vendedor")
public class VendedorBEAN {

    private int vendedorCodigo;
    private String vendedorNomeUsuario;
    private String vendedorSenha;
    private FuncionarioBEAN funcionario;

    @Id
    @GeneratedValue
    public int getVendedorCodigo() {
        return vendedorCodigo;
    }

    public void setVendedorCodigo(int vendedorCodigo) {
        this.vendedorCodigo = vendedorCodigo;
    }

    public String getVendedorNomeUsuario() {
        return vendedorNomeUsuario;
    }

    public void setVendedorNomeUsuario(String vendedorNomeUsuario) {
        this.vendedorNomeUsuario = vendedorNomeUsuario;
    }

    public String getVendedorSenha() {
        return vendedorSenha;
    }

    public void setVendedorSenha(String vendedorSenha) {
        this.vendedorSenha = vendedorSenha;
    }

    public void setFuncionario(FuncionarioBEAN funcionario) {
        this.funcionario = funcionario;
    }

    @ManyToOne
    @JoinColumn(name = "vendedor_funCodigo")
    public FuncionarioBEAN getFuncionario() {
        return funcionario;
    }

}
