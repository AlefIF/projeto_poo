/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Alef
 */
public class Venda {

    private int venCodigo;
    private String venNNF;
    private Date venData;
    private int ven_funCodigo;
    private int cliente_cliCodigo;

    public int getVenCodigo() {
        return venCodigo;
    }

    public void setVenCodigo(int venCodigo) {
        this.venCodigo = venCodigo;
    }

    public String getVenNNF() {
        return venNNF;
    }

    public void setVenNNF(String venNNF) {
        this.venNNF = venNNF;
    }

    public Date getVenDataEHora() {
        return venData;
    }

    public void setVenDataEHora(Date venData) {
        this.venData = venData;
    }

    public int getVen_funCodigo() {
        return ven_funCodigo;
    }

    public void setVen_funCodigo(int ven_funCodigo) {
        this.ven_funCodigo = ven_funCodigo;
    }

    public int getCliente_cliCodigo() {
        return cliente_cliCodigo;
    }

    public void setCliente_cliCodigo(int cliente_cliCodigo) {
        this.cliente_cliCodigo = cliente_cliCodigo;
    }

}
