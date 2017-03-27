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
public class ConsoleBEAN {

    private int conCodigo;
    private String conNome;
    private String conMarca; 

    public String getConMarca() {
        return conMarca;
    }

    public void setConMarca(String conMarca) {
        this.conMarca = conMarca;
    }

    public int getConCodigo() {
        return conCodigo;
    }

    public void setConCodigo(int conCodigo) {
        this.conCodigo = conCodigo;
    }

    public String getConNome() {
        return conNome;
    }

    public void setConNome(String conNome) {
        this.conNome = conNome;
    }

    @Override
    public String toString() {
        return getConNome(); //To change body of generated methods, choose Tools | Templates.
    }

}
