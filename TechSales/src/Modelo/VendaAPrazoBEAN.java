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
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "vendaAPrazo")
public class VendaAPrazoBEAN {

    private int vapCodigo;
    private Date vapData;
    private int vapNumParcela;
    private float vapValorParcela;
    private String vapSituacao;
    private VendaBEAN venda;

    @Id
    @GeneratedValue
    public int getVapCodigo() {
        return vapCodigo;
    }

    public void setVapCodigo(int vapCodigo) {
        this.vapCodigo = vapCodigo;
    }

    public Date getVapData() {
        return vapData;
    }

    public void setVapData(Date vapData) {
        this.vapData = vapData;
    }

    public int getVapNumParcela() {
        return vapNumParcela;
    }

    public void setVapNumParcela(int vapNumParcela) {
        this.vapNumParcela = vapNumParcela;
    }

    public float getVapValorParcela() {
        return vapValorParcela;
    }

    public void setVapValorParcela(float vapValorParcela) {
        this.vapValorParcela = vapValorParcela;
    }

    public String getVapSituacao() {
        return vapSituacao;
    }

    public void setVapSituacao(String vapSituacao) {
        this.vapSituacao = vapSituacao;
    }   

    @ManyToOne
    @JoinColumn(name="vap_vendaCodigo")
    public VendaBEAN getVenda() {
        return venda;
    }

    public void setVenda(VendaBEAN venda) {
        this.venda = venda;
    }

}
