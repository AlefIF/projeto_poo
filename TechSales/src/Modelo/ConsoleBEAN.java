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
@Table(name = "console")
public class ConsoleBEAN {

    private int conCodigo;
    private String conNome;
    private String conMarca;
    private LucroBEAN luc;

    @Id
    @GeneratedValue
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

    public String getConMarca() {
        return conMarca;
    }

    public void setConMarca(String conMarca) {
        this.conMarca = conMarca;
    }

    @ManyToOne
    public LucroBEAN getLuc() {
        return luc;
    }

    public void setLuc(LucroBEAN luc) {
        this.luc = luc;
    }

    @Override
    public String toString() {
        return getConNome(); //To change body of generated methods, choose Tools | Templates.
    }

}
