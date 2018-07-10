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

    private int venCodigo;
    private String venNNF;
    private Date venData;
    private int ven_funCodigo;
    private int cliente_cliCodigo;
    private int venNparcelas;
    private float venPrecoParcela;
    private float venEntrada;
    private FuncionarioBEAN funcionario;
    private ClienteBEAN cliente;
    private List<Item_VendaBEAN> itv;

    @Id
    @GeneratedValue
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

    public Date getVenData() {
        return venData;
    }

    public void setVenData(Date venData) {
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

    public int getVenNparcelas() {
        return venNparcelas;
    }

    public void setVenNparcelas(int venNparcelas) {
        this.venNparcelas = venNparcelas;
    }

    public float getVenPrecoParcela() {
        return venPrecoParcela;
    }

    public void setVenPrecoParcela(float venPrecoParcela) {
        this.venPrecoParcela = venPrecoParcela;
    }

    public float getVenEntrada() {
        return venEntrada;
    }

    public void setVenEntrada(float venEntrada) {
        this.venEntrada = venEntrada;
    }

    @ManyToOne
    public FuncionarioBEAN getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioBEAN funcionario) {
        this.funcionario = funcionario;
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
