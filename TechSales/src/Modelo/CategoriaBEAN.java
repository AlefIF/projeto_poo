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
public class CategoriaBEAN {

    private int catCodigo;
    private String catNome;

    public int getCatCodigo() {
        return catCodigo;
    }

    public void setCatCodigo(int catCodigo) {
        this.catCodigo = catCodigo;
    }

    public String getCatNome() {
        return catNome;
    }

    public void setCatNome(String catNome) {
        this.catNome = catNome;
    }

    @Override
    public String toString() {
        return getCatNome(); //To change body of generated methods, choose Tools | Templates.
    }
}
