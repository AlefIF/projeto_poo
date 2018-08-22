/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "venda")
public class VendaBEAN {

    private int vendaCodigo;
    private String vendaNNF;
    private Date vendaData;
    private float vendaEntrada;
    private int vendaNparcelas;
    private float vendaValorTOtal;
    private int venda_venCodigo;
    private int venda_cliCodigo;
    private VendedorBEAN vendedor;
    private ClienteBEAN cliente;
    private List<Item_VendaBEAN> itv;

    @Id
    @GeneratedValue

    public int getVendaCodigo() {
        return vendaCodigo;
    }

    public void setVendaCodigo(int vendaCodigo) {
        this.vendaCodigo = vendaCodigo;
    }

    public String getVendaNNF() {
        return vendaNNF;
    }

    public void setVendaNNF(String vendaNNF) {
        this.vendaNNF = vendaNNF;
    }

    public Date getVendaData() {
        return vendaData;
    }

    public void setVendaData(Date vendaData) {
        this.vendaData = vendaData;
    }

    public int getVenda_venCodigo() {
        return venda_venCodigo;
    }

    public void setVenda_venCodigo(int venda_venCodigo) {
        this.venda_venCodigo = venda_venCodigo;
    }

    public int getVenda_cliCodigo() {
        return venda_cliCodigo;
    }

    public void setVenda_cliCodigo(int venda_cliCodigo) {
        this.venda_cliCodigo = venda_cliCodigo;
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
    public VendedorBEAN getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorBEAN vendedor) {
        this.vendedor = vendedor;
    }

    @ManyToOne
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

    @OneToMany(mappedBy = "venda")
    @Column(nullable = false)
    public List<Item_VendaBEAN> getItv() {
        return itv;
    }

    public void setItv(List<Item_VendaBEAN> itv) {
        this.itv = itv;
    }

}
