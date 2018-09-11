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

    private int venCodigo;
    private String venNomeUsuario;
    private String venSenha;
    private FuncionarioBEAN funcionario;
  

    @Id
    @GeneratedValue
    public int getVenCodigo() {
        return venCodigo;
    }

    public void setVenCodigo(int venCodigo) {
        this.venCodigo = venCodigo;
    }

    public String getVenNomeUsuario() {
        return venNomeUsuario;
    }

    public void setVenNomeUsuario(String venNomeUsuario) {
        this.venNomeUsuario = venNomeUsuario;
    }

    public String getVenSenha() {
        return venSenha;
    }

    public void setVenSenha(String venSenha) {
        this.venSenha = venSenha;
    }

    @ManyToOne
    @JoinColumn(name="ven_funCodigo")
    public FuncionarioBEAN getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioBEAN funcionario) {
        this.funcionario = funcionario;
    }

    

}
