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
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "contas")
public class ContasBEAN {

    private int conCodigo;
    private String conDescricao;
    private float conValorTotal;
    private Date conData;
    private int conNparcelas;
    private float conPrecoParcela;

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

    public float getConPrecoParcela() {
        return conPrecoParcela;
    }

    public void setConPrecoParcela(float conPrecoParcela) {
        this.conPrecoParcela = conPrecoParcela;
    }

}