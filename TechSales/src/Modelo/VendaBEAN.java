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
@Table(name = "venda")
public class VendaBEAN {

    private int vendaCodigo;
    private Date vendaData;
    private float vendaEntrada;
    private int vendaNparcelas;
    private float vendaValorTOtal;
    private VendedorBEAN vendedor;
    private ClienteBEAN cliente;
    private CaixaBEAN caixa;
    
    @Id
    @GeneratedValue
    public int getVendaCodigo() {
        return vendaCodigo;
    }

    public void setVendaCodigo(int vendaCodigo) {
        this.vendaCodigo = vendaCodigo;
    }


    public Date getVendaData() {
        return vendaData;
    }

    public void setVendaData(Date vendaData) {
        this.vendaData = vendaData;
    }

    public int getVendaNparcelas() {
        return vendaNparcelas;
    }

    public void setVendaNparcelas(int vendaNparcelas) {
        this.vendaNparcelas = vendaNparcelas;
    }

    public float getVendaValorTOtal() {
        return vendaValorTOtal;
    }

    public void setVendaValorTOtal(float vendaValorTOtal) {
        this.vendaValorTOtal = vendaValorTOtal;
    }

    public float getVendaEntrada() {
        return vendaEntrada;
    }

    public void setVendaEntrada(float vendaEntrada) {
        this.vendaEntrada = vendaEntrada;
    }

    @ManyToOne
    @JoinColumn(name="venda_venCodigo")
    public VendedorBEAN getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorBEAN vendedor) {
        this.vendedor = vendedor;
    }

    @ManyToOne
    @JoinColumn(name="venda_cliCodigo")
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name="venda_caixaCodigo")
    public CaixaBEAN getCaixa() {
        return caixa;
    }

    public void setCaixa(CaixaBEAN caixa) {
        this.caixa = caixa;
    }
    
    

}
