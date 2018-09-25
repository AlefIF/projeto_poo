/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
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
@Table(name = "compraPrazo")
public class NotaDeCompraPrazoBEAN {

    private int napCodigo;
    private Date napData;
    private float napValor;
    private int napNumParcela;
    private String napSituacao;
    private NotaDecompraBEAN nota;

    @Id
    @GeneratedValue
    public int getNapCodigo() {
        return napCodigo;
    }

    public void setNapCodigo(int napCodigo) {
        this.napCodigo = napCodigo;
    }

    public Date getNapData() {
        return napData;
    }

    public void setNapData(Date napData) {
        this.napData = napData;
    }

    public float getNapValor() {
        return napValor;
    }

    public void setNapValor(float napValor) {
        this.napValor = napValor;
    }

    public int getNapNumParcela() {
        return napNumParcela;
    }

    public void setNapNumParcela(int napNumParcela) {
        this.napNumParcela = napNumParcela;
    }

    public String getNapSituacao() {
        return napSituacao;
    }

    public void setNapSituacao(String napSituacao) {
        this.napSituacao = napSituacao;
    } 

    @ManyToOne
    @JoinColumn(name="nap_ndcCodigo")
    public NotaDecompraBEAN getNota() {
        return nota;
    }

    public void setNota(NotaDecompraBEAN nota) {
        this.nota = nota;
    }
    
    
    

}
