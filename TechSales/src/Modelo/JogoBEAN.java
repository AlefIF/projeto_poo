/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class JogoBEAN {

    private int joCodigo;
    private String joNome;
    private String joFaixaEtaria;
    private float joPrecoPadrao;
    private String joTipo;
    private String joLote;
    private int jo_catCodigo;
    private int joQtd;
    private int joDisponibilidade;
    private CategoriaBEAN cat;
    private List<Con_jogoBEAN> con;
    private List<VendaBEAN> venda;
    private List<Aluguel> alug;
    
    @Id
    @GeneratedValue
    public int getJoCodigo() {
        return joCodigo;
    }

    public void setJoCodigo(int joCodigo) {
        this.joCodigo = joCodigo;
    }

    public String getJoNome() {
        return joNome;
    }

    public void setJoNome(String joNome) {
        this.joNome = joNome;
    }

    public String getJoFaixaEtaria() {
        return joFaixaEtaria;
    }

    public void setJoFaixaEtaria(String joFaixaEtaria) {
        this.joFaixaEtaria = joFaixaEtaria;
    }

    public float getJoPrecoPadrao() {
        return joPrecoPadrao;
    }

    public void setJoPrecoPadrao(float joPrecoPadrao) {
        this.joPrecoPadrao = joPrecoPadrao;
    }

    public String getJoTipo() {
        return joTipo;
    }

    public void setJoTipo(String joTipo) {
        this.joTipo = joTipo;
    }

    public String getJoLote() {
        return joLote;
    }

    public void setJoLote(String joLote) {
        this.joLote = joLote;
    }

    public int getJo_catCodigo() {
        return jo_catCodigo;
    }

    public void setJo_catCodigo(int jo_catCodigo) {
        this.jo_catCodigo = jo_catCodigo;
    }

    public int getJoQtd() {
        return joQtd;
    }

    public void setJoQtd(int joQtd) {
        this.joQtd = joQtd;
    }
    
    @ManyToOne
    @JoinColumn(name = "jo_catCodigo")
    public CategoriaBEAN getCat() {
        return cat;
    }

    public void setCat(CategoriaBEAN cat) {
        this.cat = cat;
    }

    @ManyToMany
    @Column(nullable = false)
    public List<Con_jogoBEAN> getCon() {
        return con;
    }

    public void setCon(List<Con_jogoBEAN> con) {
        this.con = con;
    }

    @ManyToMany
    @Column(nullable = false)
    public List<VendaBEAN> getVenda() {
        return venda;
    }

    public void setVenda(List<VendaBEAN> venda) {
        this.venda = venda;
    }

    @OneToMany(mappedBy = "loc_joCodigo")
    @Column(nullable = false)
    public List<Aluguel> getAlug() {
        return alug;
    }

    public void setAlug(List<Aluguel> alug) {
        this.alug = alug;
    }       

    @Override
    public String toString() {
        return getJoNome();
    }

}
