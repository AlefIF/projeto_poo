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
@Table(name = "notaDeCompra")
public class NotaDecompraBEAN {

    private int ndcCodigo;
    private Date ndcData;
    private float ndcPrecoTotal;
    private int ndcParcelas;
    private float ndcPrecoParcela;
    private float ndcEntrada;
    private int ndc_forCodigo;
    private String ndcDescricao;
    private int ndcSit;
    private FornecedorBEAN forne;

    @Id
    @GeneratedValue
    public int getNdcCodigo() {
        return ndcCodigo;
    }

    public void setNdcCodigo(int ndcCodigo) {
        this.ndcCodigo = ndcCodigo;
    }

    public Date getNdcData() {
        return ndcData;
    }

    public void setNdcData(Date ndcData) {
        this.ndcData = ndcData;
    }

    public float getNdcPrecoTotal() {
        return ndcPrecoTotal;
    }

    public void setNdcPrecoTotal(float ndcPrecoTotal) {
        this.ndcPrecoTotal = ndcPrecoTotal;
    }

    public int getNdcParcelas() {
        return ndcParcelas;
    }

    public void setNdcParcelas(int ndcParcelas) {
        this.ndcParcelas = ndcParcelas;
    }

    public float getNdcPrecoParcela() {
        return ndcPrecoParcela;
    }

    public void setNdcPrecoParcela(float ndcPrecoParcela) {
        this.ndcPrecoParcela = ndcPrecoParcela;
    }

    public float getNdcEntrada() {
        return ndcEntrada;
    }

    public void setNdcEntrada(float ndcEntrada) {
        this.ndcEntrada = ndcEntrada;
    }

    public int getNdc_forCodigo() {
        return ndc_forCodigo;
    }

    public void setNdc_forCodigo(int ndc_forCodigo) {
        this.ndc_forCodigo = ndc_forCodigo;
    }

    public String getNdcDescricao() {
        return ndcDescricao;
    }

    public void setNdcDescricao(String ndcDescricao) {
        this.ndcDescricao = ndcDescricao;
    }

    public int getNdcSit() {
        return ndcSit;
    }

    public void setNdcSit(int ndcSit) {
        this.ndcSit = ndcSit;
    }

    @ManyToOne
    public FornecedorBEAN getForne() {
        return forne;
    }

    public void setForne(FornecedorBEAN forne) {
        this.forne = forne;
    }

}
