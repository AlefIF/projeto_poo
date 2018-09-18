/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "jogo")
public class JogoBEAN {

    private int joCodigo;
    private String joNome;
    private String joFaixaEtaria;
    private float joPrecoPadrao;
    private String joTipo;
    private String joLote;
    private int joQtd;
    private CategoriaBEAN cat;
    private ConsoleBEAN console;
    private LucroBEAN lucro;

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

    public int getJoQtd() {
        return joQtd;
    }

    public void setJoQtd(int joQtd) {
        this.joQtd = joQtd;
    }

    @ManyToOne
    @JoinColumn(name="jo_catCodigo")
    public CategoriaBEAN getCat() {
        return cat;
    }

    public void setCat(CategoriaBEAN cat) {
        this.cat = cat;
    }

    @ManyToOne
    @JoinColumn(name="jo_conCodigo")
    public ConsoleBEAN getConsole() {
        return console;
    }

    public void setConsole(ConsoleBEAN console) {
        this.console = console;
    }

    @ManyToOne
    @JoinColumn(name="jo_lucCodigo")
    public LucroBEAN getLucro() {
        return lucro;
    }

    public void setLucro(LucroBEAN lucro) {
        this.lucro = lucro;
    }

    
    @Override
    public String toString() {
        return getJoNome();
    }

}
