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
public class MontanteBEAN {

    private int funCodigo;
    private String funNome;
    private int nVendas;
    private float valorVendas;
    private int nAluguel;
    private float valorAluguel;
    private float valorTotal;

    public int getFunCodigo() {
        return funCodigo;
    }

    public void setFunCodigo(int funCodigo) {
        this.funCodigo = funCodigo;
    }

    public String getFunNome() {
        return funNome;
    }

    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }

    public int getnVendas() {
        return nVendas;
    }

    public void setnVendas(int nVendas) {
        this.nVendas = nVendas;
    }

    public float getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(float valorVendas) {
        this.valorVendas = valorVendas;
    }

    public int getnAluguel() {
        return nAluguel;
    }

    public void setnAluguel(int nAluguel) {
        this.nAluguel = nAluguel;
    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(float valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
