/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author admin
 */
public class JogoBEAN {

    private int joCodigo;
    private String joNome;
    private String joFaixaEtaria;
    private double joPrecoPadrao;
    private String joTipo;
    private int jo_catCodigo;

    public int getJo_catCodigo() {
        return jo_catCodigo;
    }

    public void setJo_catCodigo(int jo_catCodigo) {
        this.jo_catCodigo = jo_catCodigo;
    }

    public String getJoTipo() {
        return joTipo;
    }

    public void setJoTipo(String joTipo) {
        this.joTipo = joTipo;
    }

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

    public double getJoPrecoPadrao() {
        return joPrecoPadrao;
    }

    public void setJoPrecoPadrao(double joPrecoPadrao) {
        this.joPrecoPadrao = joPrecoPadrao;
    }

}
