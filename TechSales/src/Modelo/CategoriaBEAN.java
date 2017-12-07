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
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class CategoriaBEAN {

    private int catCodigo;
    private String catNome;
    private JogoBEAN jogo;

    

    @Id
    @GeneratedValue
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
    
    @OneToMany
    @JoinColumn(name = "jo_catCodigo")
    public JogoBEAN getJogo() {
        return jogo;
    }

    public void setJogo(JogoBEAN jogo) {
        this.jogo = jogo;
    }
}
