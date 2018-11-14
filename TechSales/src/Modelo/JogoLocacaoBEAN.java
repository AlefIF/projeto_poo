/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Alef
 */
@Entity
@Table(name = "jogo_locacao")
public class JogoLocacaoBEAN {

    @EmbeddedId
    private JogoLocacaoPK chaveComposta;
    @Column(name = "jlQtd")
    private int jlQtd;

    public JogoLocacaoPK getChaveComposta() {
        return chaveComposta;
    }

    public void setChaveComposta(JogoLocacaoPK chaveComposta) {
        this.chaveComposta = chaveComposta;
    }

    public int getJlQtd() {
        return jlQtd;
    }

    public void setJlQtd(int jlQtd) {
        this.jlQtd = jlQtd;
    }

}
