/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private int jo_catCodigo;
    private int joQtd;
    private int joDisponibilidade;
    private CategoriaBEAN cat;
    private ConsoleBEAN console;

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

    public int getJoDisponibilidade() {
        return joDisponibilidade;
    }

    public void setJoDisponibilidade(int joDisponibilidade) {
        this.joDisponibilidade = joDisponibilidade;
    }

    @ManyToOne
    public CategoriaBEAN getCat() {
        return cat;
    }

    public void setCat(CategoriaBEAN cat) {
        this.cat = cat;
    }

    @ManyToOne
    public ConsoleBEAN getConsole() {
        return console;
    }

    public void setConsole(ConsoleBEAN console) {
        this.console = console;
    }

    @Override
    public String toString() {
        return getJoNome();
    }

}
