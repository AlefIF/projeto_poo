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
 * @author Maycon Jonathan
 */
@Entity
@Table(name = "devolucao")
public class DevolucaoBEAN {

    private int devCodigo;
    private Date devData;
    private float devMulta;
    private float devValor;
    private LocacaoBEAN locacao;
    private CaixaBEAN caixa;

    @Id
    @GeneratedValue
    public int getDevCodigo() {
        return devCodigo;
    }

    public void setDevCodigo(int devCodigo) {
        this.devCodigo = devCodigo;
    }

    public Date getDevData() {
        return devData;
    }

    public void setDevData(Date devData) {
        this.devData = devData;
    }

    public float getDevMulta() {
        return devMulta;
    }

    public void setDevMulta(float devMulta) {
        this.devMulta = devMulta;
    }

    public float getDevValor() {
        return devValor;
    }

    public void setDevValor(float devValor) {
        this.devValor = devValor;
    }

    @OneToOne
    @JoinColumn(name = "dev_locCodigo")
    public LocacaoBEAN getLocacao() {
        return locacao;
    }

    public void setLocacao(LocacaoBEAN locacao) {
        this.locacao = locacao;
    }

    @ManyToOne
    @JoinColumn(name = "dev_caixaCodigo")
    public CaixaBEAN getCaixa() {
        return caixa;
    }

    public void setCaixa(CaixaBEAN caixa) {
        this.caixa = caixa;
    }

}
