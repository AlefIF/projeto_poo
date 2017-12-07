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
import javax.persistence.ManyToMany;

/**
 *
 * @author admin
 */
@Entity
public class ConsoleBEAN {

    private int conCodigo;
    private String conNome;
    private String conMarca;
    private List<JogoBEAN> jogo;

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

    @ManyToMany(mappedBy = "cjg_joCodigo")
    @Column(nullable = false)
    public List<JogoBEAN> getJogo() {
        return jogo;
    }

    public void setJogo(List<JogoBEAN> jogo) {
        this.jogo = jogo;
    }

   
    @Override
    public String toString() {
        return getConNome(); //To change body of generated methods, choose Tools | Templates.
    }

}
