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
@Table(name = "contaAPrazo")
public class ContaAPrazoBEAN {

    private int capCodigo;
    private Date capData;
    private int capNumParcela;
    private float capValorParcela;
    private String capSituacao;
    private ContaBEAN conta;

    @Id
    @GeneratedValue
    public int getCapCodigo() {
        return capCodigo;
    }

    public void setCapCodigo(int capCodigo) {
        this.capCodigo = capCodigo;
    }

    public Date getCapData() {
        return capData;
    }

    public void setCapData(Date capData) {
        this.capData = capData;
    }

    public int getCapNumParcela() {
        return capNumParcela;
    }

    public void setCapNumParcela(int capNumParcela) {
        this.capNumParcela = capNumParcela;
    }

    public float getCapValorParcela() {
        return capValorParcela;
    }

    public void setCapValorParcela(float capValorParcela) {
        this.capValorParcela = capValorParcela;
    }

    public String getCapSituacao() {
        return capSituacao;
    }

    public void setCapSituacao(String capSituacao) {
        this.capSituacao = capSituacao;
    }

    @ManyToOne
    public ContaBEAN getConta() {
        return conta;
    }

    public void setConta(ContaBEAN conta) {
        this.conta = conta;
    }
    
    

}
