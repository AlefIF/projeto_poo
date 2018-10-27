/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
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
@Table(name = "conta")
public class ContaBEAN {

    private int conCodigo;
    private String conDescricao;
    private float conValorTotal;
    private Date conData;
    private int conNparcelas;
    private float conEntrada;
    private FornecedorBEAN fornecedor;
    private CaixaBEAN caixa;

    @Id
    @GeneratedValue
    public int getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(int conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getConDescricao() {
        return conDescricao;
    }

    public void setConDescricao(String conDescricao) {
        this.conDescricao = conDescricao;
    }

    public float getConValorTotal() {
        return conValorTotal;
    }

    public void setConValorTotal(float conValorTotal) {
        this.conValorTotal = conValorTotal;
    }

    public Date getConData() {
        return conData;
    }

    public void setConData(Date conData) {
        this.conData = conData;
    }

    public int getConNparcelas() {
        return conNparcelas;
    }

    public void setConNparcelas(int conNparcelas) {
        this.conNparcelas = conNparcelas;
    }

    @ManyToOne
    public FornecedorBEAN getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorBEAN fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getConEntrada() {
        return conEntrada;
    }

    public void setConEntrada(float conEntrada) {
        this.conEntrada = conEntrada;
    }

    @ManyToOne
    public CaixaBEAN getCaixa() {
        return caixa;
    }

    public void setCaixa(CaixaBEAN caixa) {
        this.caixa = caixa;
    }

}
