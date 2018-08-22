/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "endereco")
public class EnderecoBEAN {

    private int endCodigo;
    private int endNumero;
    private String endRua;
    private String endBairro;
    private String endEstado;
    private String endPais;
    private int endCliCodigo;
    private int endFuncodigo;
    private int endForcodigo;
    private ClienteBEAN cliente;
    private FuncionarioBEAN funcionario;
    private FornecedorBEAN fornecedor;

    @Id
    @GeneratedValue

    public int getEndCodigo() {
        return endCodigo;
    }

    public void setEndCodigo(int endCodigo) {
        this.endCodigo = endCodigo;
    }

    public int getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(int endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    public String getEndPais() {
        return endPais;
    }

    public void setEndPais(String endPais) {
        this.endPais = endPais;
    }

    public int getEndCliCodigo() {
        return endCliCodigo;
    }

    public void setEndCliCodigo(int endCliCodigo) {
        this.endCliCodigo = endCliCodigo;
    }

    public int getEndFuncodigo() {
        return endFuncodigo;
    }

    public void setEndFuncodigo(int endFuncodigo) {
        this.endFuncodigo = endFuncodigo;
    }

    public int getEndForcodigo() {
        return endForcodigo;
    }

    public void setEndForcodigo(int endForcodigo) {
        this.endForcodigo = endForcodigo;
    }

    @ManyToOne
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    public FuncionarioBEAN getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioBEAN funcionario) {
        this.funcionario = funcionario;
    }

    @ManyToOne
    public FornecedorBEAN getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorBEAN fornecedor) {
        this.fornecedor = fornecedor;
    }
}
