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
@Table(name = "vendaAPrazo")
public class VendaAPrazoBEAN {

    private int vapCodigo;
    private Date vapData;
    private int vapNumParcela;
    private float vapValorParcela;
    private int vapVendaCodigo;
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

    public int getVapVendaCodigo() {
        return vapVendaCodigo;
    }

    public void setVapVendaCodigo(int vapVendaCodigo) {
        this.vapVendaCodigo = vapVendaCodigo;
    }

    @ManyToOne
    public VendaBEAN getVenda() {
        return venda;
    }

    public void setVenda(VendaBEAN venda) {
        this.venda = venda;
    }

}
