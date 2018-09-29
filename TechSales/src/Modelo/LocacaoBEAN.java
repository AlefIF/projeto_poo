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
@Table(name = "locacao")
public class LocacaoBEAN {

    private int locCodigo;
    private float locPreçoTotal;
    private Date locDataAluguel;
    private ClienteBEAN cliente;
    private VendedorBEAN vendedor;
   

    @Id
    @GeneratedValue
    public int getLocCodigo() {
        return locCodigo;
    }

    public void setLocCodigo(int locCodigo) {
        this.locCodigo = locCodigo;
    }

    public float getLocPreçoTotal() {
        return locPreçoTotal;
    }

    public void setLocPreçoTotal(float locPreçoTotal) {
        this.locPreçoTotal = locPreçoTotal;
    }

    public Date getLocDataAluguel() {
        return locDataAluguel;
    }

    public void setLocDataAluguel(Date locDataAluguel) {
        this.locDataAluguel = locDataAluguel;
    }

    @ManyToOne
    @JoinColumn(name = "loc_clienteCodigo")
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name = "loc_vendedorCodigo")
    public VendedorBEAN getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorBEAN vendedor) {
        this.vendedor = vendedor;
    }

    
   
}
