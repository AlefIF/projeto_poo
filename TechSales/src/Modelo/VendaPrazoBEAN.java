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
public class VendaPrazoBEAN {

    private int vnpCodigo;
    private Date vnpDataParcela;
    private float vnpValorParcela;
    private int vnp_venCdogo;
    private VendaBEAN vend;

    @Id
    @GeneratedValue
    public int getVnpCodigo() {
        return vnpCodigo;
    }

    public void setVnpCodigo(int vnpCodigo) {
        this.vnpCodigo = vnpCodigo;
    }

    public Date getVnpDataParcela() {
        return vnpDataParcela;
    }

    public void setVnpDataParcela(Date vnpDataParcela) {
        this.vnpDataParcela = vnpDataParcela;
    }

    public float getVnpValorParcela() {
        return vnpValorParcela;
    }

    public void setVnpValorParcela(float vnpValorParcela) {
        this.vnpValorParcela = vnpValorParcela;
    }

    public int getVnp_venCdogo() {
        return vnp_venCdogo;
    }

    public void setVnp_venCdogo(int vnp_venCdogo) {
        this.vnp_venCdogo = vnp_venCdogo;
    }

    @ManyToOne
    public VendaBEAN getVend() {
        return vend;
    }

    public void setVend(VendaBEAN vend) {
        this.vend = vend;
    }

}
