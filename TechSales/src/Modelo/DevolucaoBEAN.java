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
 * @author Maycon Jonathan
 */
@Entity
@Table(name = "devolucao")
public class DevolucaoBEAN {

    private int cod;
    private Date dataDev; 
    private float multa;
    private float valor;
    private LocacaoBEAN locacao;
    private VendedorBEAN vendedor;
    private CaixaBEAN caixa;

    @Id
    @GeneratedValue
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Date getDataDev() {
        return dataDev;
    }

    public void setDataDev(Date dataDev) {
        this.dataDev = dataDev;
    }

    public float getMulta() {
        return multa;
    }

    public void setMulta(float multa) {
        this.multa = multa;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @ManyToOne
    @JoinColumn(name="dev_loCodigo")
    public LocacaoBEAN getLocacao() {
        return locacao;
    }

    public void setLocacao(LocacaoBEAN locacao) {
        this.locacao = locacao;
    }

    @ManyToOne
    @JoinColumn(name="dev_venCodigo")
    public VendedorBEAN getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorBEAN vendedor) {
        this.vendedor = vendedor;
    }

    @ManyToOne
    @JoinColumn(name="dev_caixaCodigo")
    public CaixaBEAN getCaixa() {
        return caixa;
    }

    public void setCaixa(CaixaBEAN caixa) {
        this.caixa = caixa;
    }

    
    
}
