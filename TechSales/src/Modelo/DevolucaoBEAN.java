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

/**
 *
 * @author Maycon Jonathan
 */
@Entity
public class DevolucaoBEAN {

    private int cod;
    private Date dataDev;
    private float multa;
    private int dev_funCodigo;
    private int dev_cliCodigo;
    private int dev_loCodigo;
    private String nf;
    private float valor;
    private ClienteBEAN cliente;
    private LocacaoBEAN locacao;
    private FunSql funcionario;

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

    public int getDev_funCodigo() {
        return dev_funCodigo;
    }

    public void setDev_funCodigo(int dev_funCodigo) {
        this.dev_funCodigo = dev_funCodigo;
    }

    public int getDev_cliCodigo() {
        return dev_cliCodigo;
    }

    public void setDev_cliCodigo(int dev_cliCodigo) {
        this.dev_cliCodigo = dev_cliCodigo;
    }

    public int getDev_loCodigo() {
        return dev_loCodigo;
    }

    public void setDev_loCodigo(int dev_loCodigo) {
        this.dev_loCodigo = dev_loCodigo;
    }

    public String getNf() {
        return nf;
    }

    public void setNf(String nf) {
        this.nf = nf;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @ManyToOne
    @JoinColumn(name = "dev_cliCodigo")
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name = "dev_locCodigo")
    public LocacaoBEAN getLocacao() {
        return locacao;
    }

    public void setLocacao(LocacaoBEAN locacao) {
        this.locacao = locacao;
    }

    @ManyToOne
    @JoinColumn(name = "dev_funCodigo")
    public FunSql getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FunSql funcionario) {
        this.funcionario = funcionario;
    }
    
    

  

}
