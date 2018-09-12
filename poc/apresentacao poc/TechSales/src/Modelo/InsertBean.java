/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alef
 */
public class InsertBean {

    private float joPrecoPadrao;
    private String joTipo;
    private String conNome;
    private String joLote;
    private int joQtd;

    public String getConNome() {
        return conNome;
    }

    public void setConNome(String conNome) {
        this.conNome = conNome;
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

}
