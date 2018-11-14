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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
    private float ndcEntrada;
    private float ndcCustoUnitario;
    private int ndcQtdComprada;
    private JogoBEAN jogo;
    private CaixaBEAN caixa;

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

    public float getNdcEntrada() {
        return ndcEntrada;
    }

    public void setNdcEntrada(float ndcEntrada) {
        this.ndcEntrada = ndcEntrada;
    }

    public float getNdcCustoUnitario() {
        return ndcCustoUnitario;
    }

    public void setNdcCustoUnitario(float ndcCustoUnitario) {
        this.ndcCustoUnitario = ndcCustoUnitario;
    }

    public int getNdcQtdComprada() {
        return ndcQtdComprada;
    }

    public void setNdcQtdComprada(int ndcQtdComprada) {
        this.ndcQtdComprada = ndcQtdComprada;
    }

    @OneToOne
    @JoinColumn(name = "ndc_joCodigo")
    public JogoBEAN getJogo() {
        return jogo;
    }

    public void setJogo(JogoBEAN jogo) {
        this.jogo = jogo;
    }

    @ManyToOne
    @JoinColumn(name = "ndc_caixaCodigo")
    public CaixaBEAN getCaixa() {
        return caixa;
    }

    public void setCaixa(CaixaBEAN caixa) {
        this.caixa = caixa;
    }

}
