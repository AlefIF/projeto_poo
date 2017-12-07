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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Alef
 */
@Entity
public class VendaBEAN {

    private int venCodigo;
    private String venNNF;
    private Date venData;
    private int ven_funCodigo;
    private int cliente_cliCodigo;
    private List<JogoBEAN> jogo;
    private UserBEAN funcionario;
    private ClienteBEAN cliente;

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

    @ManyToMany(mappedBy = "iv_venCodigo")
    @Column(nullable = false)
    public List<JogoBEAN> getJogo() {
        return jogo;
    }

    public void setJogo(List<JogoBEAN> jogo) {
        this.jogo = jogo;
    }

    @ManyToOne
    @JoinColumn(name = "ven_funCodigo")
    public UserBEAN getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(UserBEAN funcionario) {
        this.funcionario = funcionario;
    }

    @ManyToOne
    @JoinColumn(name = "ven_cliCodigo")
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

}
