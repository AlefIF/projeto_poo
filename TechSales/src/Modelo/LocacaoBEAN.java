/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Maycon Jonathan
 */
@Entity
@Table(name = "locacao")
public class LocacaoBEAN {

    private int cod;
    private int loc_cliCodigo;
    private int loc_venCodigo;
    private int loc_jogCodigo;
    private float valor;
    private Date data;
    private ClienteBEAN cliente;
    private FuncionarioBEAN funcionario;
    private List<DevolucaoBEAN> devolucao;

    @Id
    @GeneratedValue
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getLoc_cliCodigo() {
        return loc_cliCodigo;
    }

    public void setLoc_cliCodigo(int loc_cliCodigo) {
        this.loc_cliCodigo = loc_cliCodigo;
    }

    public int getLoc_venCodigo() {
        return loc_venCodigo;
    }

    public void setLoc_venCodigo(int loc_venCodigo) {
        this.loc_venCodigo = loc_venCodigo;
    }

    

    public int getLoc_jogCodigo() {
        return loc_jogCodigo;
    }

    public void setLoc_jogCodigo(int loc_jogCodigo) {
        this.loc_jogCodigo = loc_jogCodigo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @ManyToOne
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    public FuncionarioBEAN getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioBEAN funcionario) {
        this.funcionario = funcionario;
    }

    @OneToMany
    public List<DevolucaoBEAN> getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(List<DevolucaoBEAN> devolucao) {
        this.devolucao = devolucao;
    }

}
