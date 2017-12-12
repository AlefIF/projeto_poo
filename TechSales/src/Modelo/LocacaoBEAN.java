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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Maycon Jonathan
 */
@Entity
public class LocacaoBEAN {

    private int cod;
    private int loc_cliCodigo;
    private int loc_funCodigo;
    private int loc_jogCodigo;
    private float valor;
    private Date data;
    private JogoBEAN jogo;
    private ClienteBEAN cliente;
    private FunSql funcionario;
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

    public int getLoc_funCodigo() {
        return loc_funCodigo;
    }

    public void setLoc_funCodigo(int loc_funCodigo) {
        this.loc_funCodigo = loc_funCodigo;
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
    @JoinColumn(name = "loc_joCodigo")
    public JogoBEAN getJogo() {
        return jogo;
    }

    public void setJogo(JogoBEAN jogo) {
        this.jogo = jogo;
    }

    @ManyToOne
    @JoinColumn(name = "loc_cliCodigo")
    public ClienteBEAN getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBEAN cliente) {
        this.cliente = cliente;
    }

    @ManyToOne
    @JoinColumn(name = "loc_funCodigo")
    public FunSql getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FunSql funcionario) {
        this.funcionario = funcionario;
    }

    @OneToMany
    @JoinColumn(name = "dev_loCodigo")
    public List<DevolucaoBEAN> getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(List<DevolucaoBEAN> devolucao) {
        this.devolucao = devolucao;
    }

}
